package com.nurmatov.mindhunter.web.mapper.vacancy;

import com.nurmatov.mindhunter.domain.entity.userInfo.Vacancy;
import com.nurmatov.mindhunter.web.dto.vacancy.VacancyDto;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class VacancyMapperImpl implements VacancyMapper{
    @Override
    public VacancyDto toDto(Vacancy vacancy) {
        return new VacancyDto(
                vacancy.getId(),
                vacancy.getCompanyName(),
                vacancy.getDescription(),
                vacancy.getSkills(),
                vacancy.getCountry(),
                vacancy.getCity(),
                vacancy.getAboutCompany(),
                vacancy.getEmploymentType(),
                vacancy.getCreatedAt(),
                vacancy.getVacancyStatus(),
                vacancy.getSalary(),
                vacancy.getViews(),
                vacancy.getRespondents(),
                vacancy.getPosition()
        );
    }

    @Override
    public List<VacancyDto> toDtos(List<Vacancy> vacancies) {
        List<VacancyDto> vacancyDtos = new ArrayList<>();
        for (Vacancy vacancy: vacancies) {
            vacancyDtos.add(toDto(vacancy));
        }
        return vacancyDtos;
    }
}
