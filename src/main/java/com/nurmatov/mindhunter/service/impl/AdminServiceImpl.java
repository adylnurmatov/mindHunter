package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.service.AdminService;
import com.nurmatov.mindhunter.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    @Override
    public List<UserDto> getAllUsers(String name, String userRole) {
        return null;
    }

    @Override
    public void setRoleForUser(Long userId, String role) {

    }

    @Override
    public boolean deleteByAccount(String email) {
        return false;
    }

    @Override
    public boolean deleteByAccount(String email, String password) {
        return false;
    }

    @Override
    public boolean listForDeletingUsers(List<Long> selectedUserIds) {
        return false;
    }

    @Override
    public boolean listForDeletingVacancy(List<Long> selectedVacancyIds) {
        return false;
    }
}
