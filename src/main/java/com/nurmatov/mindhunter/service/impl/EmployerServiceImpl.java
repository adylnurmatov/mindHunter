package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.domain.entity.user.Employer;
import com.nurmatov.mindhunter.domain.entity.userInfo.Education;
import com.nurmatov.mindhunter.domain.enums.EmploymentType;
import com.nurmatov.mindhunter.domain.enums.Role;
import com.nurmatov.mindhunter.domain.enums.SalaryType;
import com.nurmatov.mindhunter.domain.enums.Valute;
import com.nurmatov.mindhunter.domain.exception.ResourceNotFoundException;
import com.nurmatov.mindhunter.repository.EmployerRepository;
import com.nurmatov.mindhunter.repository.UserRepository;
import com.nurmatov.mindhunter.service.EmployerService;
import com.nurmatov.mindhunter.web.dto.employer.EmployerDto;
import com.nurmatov.mindhunter.web.mapper.employer.EmployerMapper;
import com.nurmatov.mindhunter.web.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService {
    private final UserRepository userRepository;
    private final EmployerMapper employerMapper;
    private final EmployerRepository employerRepository;
    @Override
    public List<EmployerDto> getAll() {
        return employerMapper.toDtos(employerRepository.findAll());
    }

    @Override
    public EmployerDto update(Long id, EmployerDto employerDto) {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
        employer.setEmail(employerDto.getEmail());
        employer.setRole(employerDto.getRole());
        employer.setPassword(employerDto.getPassword());
        employer.setUsername(employerDto.getUsername());
        employerRepository.saveAndFlush(employer);
        return employerDto;
    }

    @Override
    public EmployerDto getById(Long id) {
        return employerMapper.toDto(employerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND")));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<Education> getEducations(Long id) {
        return null;
    }

    @Override
    public List<String> getTypeOfEmployments() {
        List<String> strings = new ArrayList<>();
        strings.add(String.valueOf(EmploymentType.WFH));
        strings.add(String.valueOf(EmploymentType.FULL_TIME));
        strings.add(String.valueOf(EmploymentType.HALF_TIME));
        return strings;
    }

    @Override
    public List<String> getSalaryTypes() {
        List<String> strings = new ArrayList<>();
        strings.add(String.valueOf(SalaryType.FIX));
        strings.add(String.valueOf(SalaryType.FULL));
        strings.add(String.valueOf(SalaryType.GIBRID));
        return strings;
    }

    @Override
    public List<String> getValutes() {
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(Valute.USD));
        list.add(String.valueOf(Valute.RUB));
        list.add(String.valueOf(Valute.SOM));
        return list;
    }

}
