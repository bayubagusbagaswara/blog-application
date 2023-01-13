package com.bayu.blog.service;

import com.bayu.blog.payload.LoginDTO;
import com.bayu.blog.payload.RegisterDTO;

public interface AuthService {

    String login(LoginDTO loginDTO);

    String register(RegisterDTO registerDTO);

}
