package com.erp.Ecommeres.controller;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.erp.Ecommeres.dto.MailBody;
import com.erp.Ecommeres.entity.ForgotPassword;
import com.erp.Ecommeres.entity.User;
import com.erp.Ecommeres.repo.ForgotPasswordRepo;
import com.erp.Ecommeres.repo.UserRepo;
import com.erp.Ecommeres.service.EmailService;
import com.erp.Ecommeres.utils.ChangePassword;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/forgot-password")
@RequiredArgsConstructor
public class ForgotPasswordController {

    private final UserRepo userRepo;
    private final ForgotPasswordRepo forgotRepo;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<String> sendOtp(@PathVariable String email) {

        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found"));

        forgotRepo.deleteByUserEmail(email);

        int otp = new Random().nextInt(900000) + 100000;

        forgotRepo.save(ForgotPassword.builder()
                .otp(otp)
                .expirationTime(new Date(System.currentTimeMillis() + 5 * 60 * 1000))
                .user(user)
                .build());

        emailService.sendSimpleMessage(
                MailBody.builder()
                        .to(email)
                        .subject("OTP")
                        .text("Your OTP is: " + otp)
                        .build());

        return ResponseEntity.ok("OTP sent");
    }

    @PostMapping("/verifyOtp/{otp}/{email}")
    public ResponseEntity<String> verifyOtp(@PathVariable Integer otp,
                                            @PathVariable String email) {

        ForgotPassword forgotPassword =
                forgotRepo.findOtpByEmail(otp, email)
                        .orElseThrow(() -> new RuntimeException("Invalid OTP"));

        if (forgotPassword.getExpirationTime().before(new Date())) {
            forgotRepo.deleteByUserEmail(email);
            return ResponseEntity.badRequest().body("OTP expired");
        }

        return ResponseEntity.ok("OTP verified");
    }

    @PostMapping("/changePassword/{email}")
    public ResponseEntity<String> resetPassword(@RequestBody ChangePassword request,
                                                @PathVariable String email) {

        if (!Objects.equals(request.password(), request.repeatPassword())) {
            return ResponseEntity.badRequest().body("Passwords do not match");
        }

        userRepo.updatePassword(email, passwordEncoder.encode(request.password()));
        forgotRepo.deleteByUserEmail(email);

        return ResponseEntity.ok("Password changed successfully");
    }
}
