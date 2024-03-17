package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.domain.entity.user.User;
import com.nurmatov.mindhunter.domain.enums.Role;
import com.nurmatov.mindhunter.domain.exception.ResourceNotFoundException;
import com.nurmatov.mindhunter.repository.UserRepository;
import com.nurmatov.mindhunter.service.EmployerService;
import com.nurmatov.mindhunter.service.JobSeekerService;
import com.nurmatov.mindhunter.service.UserService;
import com.nurmatov.mindhunter.web.dto.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final JobSeekerService jobSeekerService;
    private final EmployerService employerService;

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
    }

    @Override
    public User getByEmail(String email) {
        Optional<User> user =userRepository.findByEmail(email);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("NOT_FOUND");
        }
        return user.get();
    }

    @Override
    public User getByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new ResourceNotFoundException("NOT_FOUND");
        }
        return user.get();
    }
    @Override
    public String changePassword(String email, String oldPassword, String newPassword) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
        if(user.getPassword().equals(oldPassword)){
            user.setPassword(newPassword);
            return newPassword;
        }
        else{
            return oldPassword;
        }
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        if(userDto.getRole().equals(Role.EMPLOYER)){
            employerService.create(userDto);
        }
        else{
            jobSeekerService.create(userDto);
        }
        return userDto;
    }

}
