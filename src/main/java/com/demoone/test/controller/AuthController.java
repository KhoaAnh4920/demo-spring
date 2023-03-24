package com.demoone.test.controller;

import com.demoone.test.model.dto.LoginDto;
import com.demoone.test.model.dto.RegisterDto;
import com.demoone.test.services.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Register
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        System.out.println("registerDto: "+ registerDto);
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public String login(@RequestBody LoginDto loginDto){
        System.out.println("Login: " + loginDto);

        return authService.login(loginDto);
    }
}
