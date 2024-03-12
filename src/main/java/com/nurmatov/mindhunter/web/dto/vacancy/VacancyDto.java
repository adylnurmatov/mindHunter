package com.nurmatov.mindhunter.web.dto.vacancy;

import com.nurmatov.mindhunter.domain.entity.user.JobSeeker;
import com.nurmatov.mindhunter.domain.entity.userInfo.Position;
import com.nurmatov.mindhunter.domain.entity.userInfo.Salary;
import com.nurmatov.mindhunter.domain.enums.EmploymentType;
import com.nurmatov.mindhunter.domain.enums.VacancyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class VacancyDto {
    private Long id;
    private String companyName;
    private String description;
    private String skills;
    private String country;
    private String city;
    private String aboutCompany;
    private EmploymentType employmentType;
    private LocalDateTime createdAt;
    private VacancyStatus vacancyStatus;
    private Salary salary;
    private Integer views;
    private List<JobSeeker> respondents;
    private Position position;
}
