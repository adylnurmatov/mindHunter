package com.nurmatov.mindhunter.service;


import com.nurmatov.mindhunter.domain.entity.user.User;

public interface UserService {
    User getById(Long userId);

    User getByEmail(String email);

    User getByUsername(String username);

    boolean changePassword(String email, String password);

    String changePassword(String email, String oldPassword, String newPassword);
}
