package com.nurmatov.mindhunter.repository;

import com.nurmatov.mindhunter.domain.entity.userInfo.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findTop5ByOrderByViewsAsc();
}
