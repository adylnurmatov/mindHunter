package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.domain.entity.userInfo.Education;
import com.nurmatov.mindhunter.domain.entity.userInfo.Position;
import com.nurmatov.mindhunter.domain.entity.userInfo.Profession;
import com.nurmatov.mindhunter.service.JobSeekerService;
import com.nurmatov.mindhunter.web.dto.JobSeeker.JobSeekerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobSeekerServiceImpl implements JobSeekerService {
    @Override
    public List<String> getStatusOfJobSeeker() {
        return null;
    }

    @Override
    public List<JobSeekerDto> findByName(String name, String email) {
        return null;
    }



    @Override
    public List<JobSeekerDto> getAllJobSeekers() {
        return null;
    }

    @Override
    public JobSeekerDto save(JobSeekerDto jobSeeker) {
        return null;
    }

    @Override
    public JobSeekerDto update(Long id, JobSeekerDto jobSeeker) {
        return null;
    }

    @Override
    public JobSeekerDto getById(Long id) {
        return null;
    }

    @Override
    public List<JobSeekerDto> filter(String position, String education, String country, String city, String experience) {
        return null;
    }


    @Override
    public List<JobSeekerDto> searchByFirstAndLastName(String firstname, String lastname) {
        return null;
    }

    @Override
    public List<JobSeekerDto> getAllPositions() {
        return null;
    }

    @Override
    public String getExperience(List<Profession> professions) {
        return null;
    }
}
