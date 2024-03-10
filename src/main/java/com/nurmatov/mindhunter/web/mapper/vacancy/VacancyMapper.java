package com.nurmatov.mindhunter.web.mapper.vacancy;

import com.nurmatov.mindhunter.domain.entity.userInfo.Category;
import com.nurmatov.mindhunter.domain.entity.userInfo.Vacancy;
import com.nurmatov.mindhunter.web.dto.category.CategoryDto;
import com.nurmatov.mindhunter.web.dto.vacancy.VacancyDto;

import java.util.List;

public interface VacancyMapper {
    VacancyDto toDto(Vacancy vacancy);
    List<VacancyDto> toDtos(List<Vacancy> vacancies);
}
