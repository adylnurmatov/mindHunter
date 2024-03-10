package com.nurmatov.mindhunter.domain.entity.user;

import com.nurmatov.mindhunter.domain.entity.userInfo.Education;
import com.nurmatov.mindhunter.domain.entity.userInfo.Image;
import com.nurmatov.mindhunter.domain.entity.userInfo.Profession;
import com.nurmatov.mindhunter.domain.entity.userInfo.Vacancy;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "job_seeker")
public class JobSeeker extends User{
    private LocalDateTime birthday;
    @OneToOne(cascade = CascadeType.ALL)
    private Profession profession;
    @OneToOne(cascade = CascadeType.ALL)
    private Image profilePicture;
    @OneToOne(cascade = CascadeType.ALL)
    private Image resume;
    @ManyToMany
    private List<Vacancy> vacancies;
    @OneToOne(cascade = CascadeType.ALL)
    private Education education;
    private String address;
    private String country;
    private String city;
    private String about;
    private String phoneNumber;
}
