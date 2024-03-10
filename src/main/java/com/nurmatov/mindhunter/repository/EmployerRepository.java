package com.nurmatov.mindhunter.repository;


import com.nurmatov.mindhunter.domain.entity.user.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
