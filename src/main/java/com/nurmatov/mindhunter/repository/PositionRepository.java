package com.nurmatov.mindhunter.repository;


import com.nurmatov.mindhunter.domain.entity.userInfo.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
