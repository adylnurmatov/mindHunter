package com.nurmatov.mindhunter.service;


import com.nurmatov.mindhunter.domain.entity.userInfo.Education;
import com.nurmatov.mindhunter.web.dto.employer.EmployerDto;

import java.util.List;

public interface EmployerService {
    List<EmployerDto> getAll();

    EmployerDto update(Long id, EmployerDto employerDto);

    EmployerDto getById(Long id);

    void deleteById(Long id);

    List<Education> getEducations( Long id);

    List<String> getTypeOfEmployments();

    List<String> getSalaryTypes();

    List<String> getValutes();
}
