package com.nurmatov.mindhunter.repository;


import com.nurmatov.mindhunter.domain.entity.userInfo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
