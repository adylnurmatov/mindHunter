package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.domain.entity.userInfo.Education;
import com.nurmatov.mindhunter.repository.UserRepository;
import com.nurmatov.mindhunter.service.EmployerService;
import com.nurmatov.mindhunter.web.dto.employer.EmployerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {
    private final UserRepository userRepository;
    @Override
    public List<EmployerDto> getAll() {
        return null;
    }

    @Override
    public EmployerDto save(EmployerDto employerDto) {
        return null;
    }

    @Override
    public EmployerDto update(Long id, EmployerDto employerDto) {
        return null;
    }

    @Override
    public EmployerDto getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Education> getEducations() {
        return null;
    }

    @Override
    public List<String> getTypeOfEmployments() {
        return null;
    }

    @Override
    public List<String> getSalaryTypes() {
        return null;
    }

    @Override
    public List<String> getValutes() {
        return null;
    }
}
