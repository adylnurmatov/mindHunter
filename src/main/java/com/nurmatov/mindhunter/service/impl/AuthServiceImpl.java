package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.domain.entity.user.User;
import com.nurmatov.mindhunter.service.AuthService;
import com.nurmatov.mindhunter.service.UserService;
import com.nurmatov.mindhunter.web.dto.auth.UserRequest;
import com.nurmatov.mindhunter.web.dto.auth.UserResponse;
import com.nurmatov.mindhunter.web.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public UserResponse login(final UserRequest loginRequest) {
        UserResponse userResponse = new UserResponse();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword())
        );
        User user = userService.getByUsername(loginRequest.getUsername());
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setRole(user.getRole());
        userResponse.setAccessToken(jwtTokenProvider.createAccessToken(
                user.getId(), user.getUsername(), user.getRole())
        );
        userResponse.setRefreshToken(jwtTokenProvider.createRefreshToken(
                user.getId(), user.getUsername())
        );
        return userResponse;
    }

    @Override
    public UserResponse refresh(final String refreshToken) {
        return jwtTokenProvider.refreshUserTokens(refreshToken);
    }
}
