package com.example.manageprojectemployeeretro.controller.rest;

import com.example.manageprojectemployeeretro.dto.LoginRequest;
import com.example.manageprojectemployeeretro.dto.SignUpRequest;
import com.example.manageprojectemployeeretro.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class LoginRestController {
    private final AuthService authService;
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser( SignUpRequest signUpRequest) {
        ResponseEntity<?> response =  authService.registerUser(signUpRequest);
        if (response.getStatusCode() == HttpStatus.OK) {
            // Đăng nhập thành công, trả về URL của trang chính
            String mainPageUrl = "http://localhost:7777/admin/adminUser/Login.html"; // Thay đổi đường dẫn này cho phù hợp với URL của trang chính
            return ResponseEntity.ok(mainPageUrl);
        } else {
            // Đăng nhập thất bại, trả về response như cũ
            return response;
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) {
        ResponseEntity<?> response = authService.authenticateUser(loginRequest);

        if (response.getStatusCode() == HttpStatus.OK) {
            // Đăng nhập thành công, trả về URL của trang chính
            String mainPageUrl = "/admin/main.html#!/checkin"; // Thay đổi đường dẫn này cho phù hợp với URL của trang chính
            return ResponseEntity.ok(mainPageUrl);
        } else {
            // Đăng nhập thất bại, trả về response như cũ
            return response;
        }

    }

    @GetMapping("/main")
    public String viewMain(){
        return "admin/main";
    }


}
