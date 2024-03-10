package com.nurmatov.mindhunter.web.mapper.vacancy;

import com.nurmatov.mindhunter.domain.entity.userInfo.Vacancy;
import com.nurmatov.mindhunter.web.dto.vacancy.VacancyDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VacancyMapperImpl implements VacancyMapper{
    @Override
    public VacancyDto toDto(Vacancy vacancy) {
        return null;
    }

    @Override
    public List<VacancyDto> toDtos(List<Vacancy> vacancies) {
        return null;
    }
}
