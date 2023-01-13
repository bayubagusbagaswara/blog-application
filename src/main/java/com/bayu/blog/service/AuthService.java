package com.bayu.blog.service;

import com.bayu.blog.payload.LoginDTO;

public interface AuthService {

    String login(LoginDTO loginDTO);

}
