package com.example.passwordman.controller;

import com.example.passwordman.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthController {

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public ResponseEntity<String> token (Authentication authentication) {
        log.debug("Token requested for user: {}", authentication.getName());

        String token =  tokenService.generateToken(authentication);

        log.debug("Token generated for user: {}", authentication.getName());

        return ResponseEntity.ok().body(token);
    }

}
