package com.example.dishdiscoveryapi.controller;

import com.example.dishdiscoveryapi.dto.JwtAuthenticationResponse;
import com.example.dishdiscoveryapi.dto.SignInRequest;
import com.example.dishdiscoveryapi.dto.SignUpRequest;
import com.example.dishdiscoveryapi.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public JwtAuthenticationResponse signUp(@RequestBody SignUpRequest request) {
        log.info("Sign up request: {}", request);
        return authenticationService.signup(request);
    }


    @PostMapping("/signin")
    public JwtAuthenticationResponse signIn(@RequestBody SignInRequest request) {
        return authenticationService.signin(request);
    }
}
