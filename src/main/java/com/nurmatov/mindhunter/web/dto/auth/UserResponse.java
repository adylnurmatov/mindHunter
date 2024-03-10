package com.nurmatov.mindhunter.web.dto.auth;


import com.nurmatov.mindhunter.domain.enums.Role;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String username;
    private Role role;
    private String accessToken;
    private String refreshToken;

}
