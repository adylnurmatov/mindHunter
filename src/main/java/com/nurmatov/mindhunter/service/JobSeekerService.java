package com.nurmatov.mindhunter.service;


import com.nurmatov.mindhunter.domain.entity.userInfo.Education;
import com.nurmatov.mindhunter.domain.entity.userInfo.Position;
import com.nurmatov.mindhunter.domain.entity.userInfo.Profession;
import com.nurmatov.mindhunter.web.dto.JobSeeker.JobSeekerDto;

import java.util.List;

public interface JobSeekerService {

    List<JobSeekerDto> findByName(String name);


//    FileResponse uploadResume(MultipartFile file, Long id);


    List<JobSeekerDto> getAllJobSeekers();


    JobSeekerDto update(Long id, JobSeekerDto jobSeeker);

    JobSeekerDto getById(Long id);

    List<JobSeekerDto> filter(Position position,
                              Education education,
                              String country,
                              String city,
                              String experienceName);



    List<JobSeekerDto> searchByFirstAndLastName(
            String firstname,
            String lastname
    );

    List<Position> getAllPositions();
}
