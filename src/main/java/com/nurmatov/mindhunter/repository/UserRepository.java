package com.nurmatov.mindhunter.repository;


import com.nurmatov.mindhunter.domain.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    void deleteByEmail(String email);
    void deleteByEmailAndPassword(String email, String password);
}
