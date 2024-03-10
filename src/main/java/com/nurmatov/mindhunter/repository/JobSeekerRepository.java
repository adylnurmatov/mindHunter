package com.nurmatov.mindhunter.repository;


import com.nurmatov.mindhunter.domain.entity.user.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
}
