package com.nurmatov.mindhunter.web.mapper.jobSeeker;

import com.nurmatov.mindhunter.domain.entity.user.JobSeeker;
import com.nurmatov.mindhunter.web.dto.JobSeeker.JobSeekerDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobSeekerMapperImpl implements JobSeekerMapper{
    @Override
    public JobSeekerDto toDto(JobSeeker jobSeeker) {
        return new JobSeekerDto(
                jobSeeker.getId(),
                jobSeeker.getUsername(),
                jobSeeker.getEmail(),
                jobSeeker.getPassword(),
                jobSeeker.getRole()
        );
    }

    @Override
    public List<JobSeekerDto> toDtos(List<JobSeeker> jobSeekers) {
        List<JobSeekerDto> jobSeekerDtos = new ArrayList<>();
        for (JobSeeker jobseeker: jobSeekers) {
            jobSeekerDtos.add(toDto(jobseeker));
        }
        return jobSeekerDtos;
    }
}
