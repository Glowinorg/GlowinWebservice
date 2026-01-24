package com.erp.Ecommeres.controller;

import java.io.IOException;
import java.util.Map;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.erp.Ecommeres.entity.Profile;
import com.erp.Ecommeres.service.ProfileService;


@RestController
@RequestMapping("/api/profile")
@CrossOrigin
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    // CREATE or UPDATE profile
    @PostMapping("/save")
    public ResponseEntity<?> saveProfile(@RequestBody Profile profile) {
        return ResponseEntity.ok(profileService.saveOrUpdateProfile(profile));
    }

    // GET profile
    @GetMapping("/{userId}")
    public ResponseEntity<?> getProfile(@PathVariable Long userId) {
        return ResponseEntity.ok(profileService.getProfile(userId));
    }
}
