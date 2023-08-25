package com.example.manageprojectemployeeretro.service;

import com.example.manageprojectemployeeretro.dto.LoginRequest;
import com.example.manageprojectemployeeretro.dto.SignUpRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> registerUser(SignUpRequest signUpRequest);
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
}
