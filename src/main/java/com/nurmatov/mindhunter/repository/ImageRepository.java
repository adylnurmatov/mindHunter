package com.nurmatov.mindhunter.repository;

import com.nurmatov.mindhunter.domain.entity.userInfo.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
