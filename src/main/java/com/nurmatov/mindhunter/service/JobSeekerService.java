package com.nurmatov.mindhunter.service;


import com.nurmatov.mindhunter.domain.entity.userInfo.Education;
import com.nurmatov.mindhunter.domain.entity.userInfo.Position;
import com.nurmatov.mindhunter.domain.entity.userInfo.Profession;
import com.nurmatov.mindhunter.web.dto.JobSeeker.JobSeekerDto;

import java.util.List;

public interface JobSeekerService {
    List<String> getStatusOfJobSeeker();

    List<JobSeekerDto> findByName(String name, String email);


//    FileResponse uploadResume(MultipartFile file, Long id);


    List<JobSeekerDto> getAllJobSeekers();

    JobSeekerDto save(JobSeekerDto jobSeeker);

    JobSeekerDto update(Long id, JobSeekerDto jobSeeker);

    JobSeekerDto getById(Long id);

    List<JobSeekerDto> filter(String position, String education, String country, String city, String experience);



    List<JobSeekerDto> searchByFirstAndLastName(
            String firstname,
            String lastname
    );

    List<JobSeekerDto> getAllPositions();
    String getExperience(List<Profession> professions);
}
