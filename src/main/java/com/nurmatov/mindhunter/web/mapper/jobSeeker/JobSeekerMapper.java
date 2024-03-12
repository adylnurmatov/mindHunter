package com.nurmatov.mindhunter.web.mapper.jobSeeker;

import com.nurmatov.mindhunter.domain.entity.user.JobSeeker;
import com.nurmatov.mindhunter.web.dto.JobSeeker.JobSeekerDto;

import java.util.List;

public interface JobSeekerMapper {
    JobSeekerDto toDto(JobSeeker jobSeeker);
    List<JobSeekerDto> toDtos(List<JobSeeker> jobSeekers);
}
