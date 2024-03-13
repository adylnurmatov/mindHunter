package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.repository.UserRepository;
import com.nurmatov.mindhunter.service.AdminService;
import com.nurmatov.mindhunter.web.dto.user.UserDto;
import com.nurmatov.mindhunter.web.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public List<UserDto> getAllUsers(String name, String userRole) {
        return userMapper.toDtos(userRepository.findAll());
    }

    @Override
    public boolean deleteByAccount(String email) {
        userRepository.deleteByEmail(email);
        return true;
    }

    @Override
    public boolean deleteByAccount(String email, String password) {
        userRepository.deleteByEmailAndPassword(email, password);
        return true;
    }
}
