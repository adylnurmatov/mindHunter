package com.nurmatov.mindhunter.web.dto.auth;

import com.nurmatov.mindhunter.domain.entity.enums.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequest {
    @NotNull(message = "username must be not null")
    private String username;
    @NotNull(message = "password must be not null")
    private String password;
    @NotNull(message = "role must be not null")
    private Role role;
}
