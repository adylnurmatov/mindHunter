package com.nurmatov.mindhunter.service;


import com.nurmatov.mindhunter.web.dto.user.UserDto;

import java.util.List;

public interface AdminService {
    List<UserDto> getAllUsers(String name, String userRole);

    void setRoleForUser(Long userId, String role);

    boolean deleteByAccount(String email);

    boolean deleteByAccount(String email, String password);

    boolean listForDeletingUsers(List<Long> selectedUserIds);
    boolean listForDeletingVacancy(List<Long> selectedVacancyIds);


}
