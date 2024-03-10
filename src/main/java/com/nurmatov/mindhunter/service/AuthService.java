package com.nurmatov.mindhunter.service;


import com.nurmatov.mindhunter.web.dto.auth.UserRequest;
import com.nurmatov.mindhunter.web.dto.auth.UserResponse;

public interface AuthService {

    UserResponse login(UserRequest userRequest);
    UserResponse refresh(String refreshToken);
}
