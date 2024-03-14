package com.nurmatov.mindhunter.repository;


import com.nurmatov.mindhunter.domain.entity.user.User;

import com.nurmatov.mindhunter.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
    void deleteByEmail(String email);
    void deleteByEmailAndPassword(String email, String password);
    List<User> findUserByRole(Role role);

}
