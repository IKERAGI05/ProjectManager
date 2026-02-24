package com.portfolio.pm.project_manager_api.controllers;

import com.portfolio.pm.project_manager_api.core.model.dto.user.AuthResponse;
import com.portfolio.pm.project_manager_api.core.model.dto.user.LoginRequest;
import com.portfolio.pm.project_manager_api.core.model.dto.user.RegisterRequest;
import com.portfolio.pm.project_manager_api.core.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody @Valid RegisterRequest request) {
        AuthResponse response = userService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request) {
        AuthResponse response = userService.login(request);
        return ResponseEntity.ok(response);
    }
}
