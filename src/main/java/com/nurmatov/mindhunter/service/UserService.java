package com.nurmatov.mindhunter.service;


import com.nurmatov.mindhunter.domain.entity.user.User;
import com.nurmatov.mindhunter.web.dto.user.UserDto;

public interface UserService {
    User getById(Long userId);

    User getByEmail(String email);

    User getByUsername(String username);


    String changePassword(String email, String oldPassword, String newPassword);
    UserDto createUser(UserDto userDto);
}
