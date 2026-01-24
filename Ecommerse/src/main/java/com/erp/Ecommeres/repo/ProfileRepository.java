package com.erp.Ecommeres.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erp.Ecommeres.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByUserId(Long userId);
}
