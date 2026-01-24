package com.erp.Ecommeres.service;

import org.springframework.stereotype.Service;

import com.erp.Ecommeres.entity.Profile;
import com.erp.Ecommeres.repo.ProfileRepository;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    // 🔥 THIS METHOD MUST EXIST
    public Profile saveOrUpdateProfile(Profile profileRequest) {

        return profileRepository.findByUserId(profileRequest.getUserId())
                .map(existingProfile -> {
                    existingProfile.setAge(profileRequest.getAge());
                    existingProfile.setGender(profileRequest.getGender());
                    existingProfile.setImageUrl(profileRequest.getImageUrl());
                    return profileRepository.save(existingProfile);
                })
                .orElseGet(() -> profileRepository.save(profileRequest));
    }

    public Profile getProfile(Long userId) {
        return profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
    }
}
