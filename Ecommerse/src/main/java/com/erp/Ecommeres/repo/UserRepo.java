package com.erp.Ecommeres.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.Ecommeres.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByMobileNumber(String mobileNumber);
}
