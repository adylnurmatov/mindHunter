package com.nurmatov.mindhunter.web.dto.JobSeeker;

import com.nurmatov.mindhunter.domain.enums.Role;
import com.nurmatov.mindhunter.web.dto.validation.OnCreate;
import com.nurmatov.mindhunter.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class JobSeekerDto {
    @NotNull(message = "id cannot be null", groups = OnUpdate.class)
    private Long id;
    @NotNull(message = "username cannot be null", groups = {OnUpdate.class, OnCreate.class})
    private String username;
    @NotNull(message = "email cannot be null", groups = {OnUpdate.class, OnCreate.class})
    private String email;
    @NotNull(message = "password cannot be null", groups = {OnUpdate.class, OnCreate.class})
    private String password;
    @NotNull(message = "role cannot be null", groups = OnCreate.class)
    private Role role;
}
