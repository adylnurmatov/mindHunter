package com.nurmatov.mindhunter.service.impl;

import com.nurmatov.mindhunter.domain.entity.user.JobSeeker;
import com.nurmatov.mindhunter.domain.entity.userInfo.Education;
import com.nurmatov.mindhunter.domain.entity.userInfo.Position;
import com.nurmatov.mindhunter.domain.entity.userInfo.Profession;
import com.nurmatov.mindhunter.domain.exception.ResourceNotFoundException;
import com.nurmatov.mindhunter.repository.JobSeekerRepository;
import com.nurmatov.mindhunter.repository.PositionRepository;
import com.nurmatov.mindhunter.service.JobSeekerService;
import com.nurmatov.mindhunter.web.dto.JobSeeker.JobSeekerDto;
import com.nurmatov.mindhunter.web.mapper.jobSeeker.JobSeekerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobSeekerServiceImpl implements JobSeekerService {
    private final JobSeekerRepository jobSeekerRepository;
    private final JobSeekerMapper jobSeekerMapper;
    private final PositionRepository positionRepository;

    @Override
    public List<JobSeekerDto> findByName(String name) {
        return jobSeekerMapper.toDtos(jobSeekerRepository.findAllByUsername(name));
    }



    @Override
    public List<JobSeekerDto> getAllJobSeekers() {
        return jobSeekerMapper.toDtos(jobSeekerRepository.findAll());
    }


    @Override
    public JobSeekerDto update(Long id, JobSeekerDto jobSeekerDto) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("NOT_FOUND"));
        jobSeeker.setUsername(jobSeekerDto.getUsername());
        jobSeeker.setEmail(jobSeekerDto.getEmail());
        jobSeeker.setRole(jobSeekerDto.getRole());
        jobSeeker.setPassword(jobSeekerDto.getPassword());
        return jobSeekerDto;
    }

    @Override
    public JobSeekerDto getById(Long id) {
        return jobSeekerMapper.toDto(jobSeekerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("NOT_FOUND")));
    }
    @Override
    public List<JobSeekerDto> filter(
            Position position,
            Education education,
            String country,
            String city,
            String experienceName
    ) {
        if (position == null && (country == null || country.isEmpty()) &&
                (city == null || city.isEmpty()) && (experienceName == null || experienceName.isEmpty()) &&
                education == null) {
            return jobSeekerMapper.toDtos(jobSeekerRepository.findAll());
        }

        return jobSeekerMapper.toDtos(jobSeekerRepository.filterJobSeekers(
                position != null ? position.getName() : null,
                education,
                country != null && !country.isEmpty() ? country : null,
                city != null && !city.isEmpty() ? city : null,
                experienceName
        ));
    }


    @Override
    public List<JobSeekerDto> searchByFirstAndLastName(String firstname, String lastname) {
        return jobSeekerMapper.toDtos(jobSeekerRepository.searchJobSeekers(
                firstname != null && !firstname.isEmpty() ? firstname : null,
                lastname != null && !lastname.isEmpty() ? lastname : null

        ));
    }

    @Override
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }
}
