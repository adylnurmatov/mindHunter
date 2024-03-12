package com.nurmatov.mindhunter.web.mapper.employer;

import com.nurmatov.mindhunter.domain.entity.user.Employer;
import com.nurmatov.mindhunter.web.dto.employer.EmployerDto;

import java.util.List;

public interface EmployerMapper {
    EmployerDto toDto(Employer employer);
    List<EmployerDto> toDtos(List<Employer> employers);

}
