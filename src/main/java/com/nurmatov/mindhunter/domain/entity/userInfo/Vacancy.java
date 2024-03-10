package com.nurmatov.mindhunter.domain.entity.userInfo;

import com.nurmatov.mindhunter.domain.entity.user.JobSeeker;
import com.nurmatov.mindhunter.domain.enums.EmploymentType;
import com.nurmatov.mindhunter.domain.enums.VacancyStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Entity
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String aboutCompany;
    private String description;
    private String country;
    private String city;
    private String skills;
    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;
    private LocalDateTime createdAt;
    @Enumerated(EnumType.STRING)
    private VacancyStatus vacancyStatus;
    @OneToOne
    private Salary salary;
    private Integer views;
    @ManyToMany
    private List<JobSeeker> respondents;
    @OneToOne
    private Position position;
}