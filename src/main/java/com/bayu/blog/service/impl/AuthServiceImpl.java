package com.bayu.blog.service.impl;

import com.bayu.blog.entity.Role;
import com.bayu.blog.entity.User;
import com.bayu.blog.exception.BlogApiException;
import com.bayu.blog.payload.LoginDTO;
import com.bayu.blog.payload.RegisterDTO;
import com.bayu.blog.repository.RoleRepository;
import com.bayu.blog.repository.UserRepository;
import com.bayu.blog.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsernameOrEmail(), loginDTO.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "User Logged-in successfully!.";
    }

    @Override
    public String register(RegisterDTO registerDTO) {
        // add check for username exists in database
        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Username is already exists!");
        }

        // add check for email exists in database
        if (userRepository.existsByEmail(registerDTO.getEmail())) {
            throw new BlogApiException(HttpStatus.BAD_REQUEST, "Email is already exists!");
        }

        User user = new User();
        user.setName(registerDTO.getName());
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);

        return "User registered successfully";
    }

}
