package com.example.passwordman.controller;

import com.example.passwordman.model.PasswordGenerateRequest;
import com.example.passwordman.service.PasswordService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @PostMapping("/generate")
    public String generatePassword(@Valid @RequestBody PasswordGenerateRequest passwordGenerateRequest) {
        log.info("Received request to generate password for website: {}", passwordGenerateRequest.getWebsite());
        return passwordService.generateAndStore(passwordGenerateRequest);
    }

    @PostMapping("/get")
    public String getPassword(@Valid @RequestBody PasswordGenerateRequest passwordGenerateRequest) {
        log.info("Received request to get password for website: {}", passwordGenerateRequest.getWebsite());
        return passwordService.getPasswordForWebsiteAndUserName(passwordGenerateRequest);
    }

    @PostMapping("/save")
    public String savePassword(@Valid @RequestBody PasswordGenerateRequest passwordGenerateRequest) {
        log.info("Received request to save password for website: {}", passwordGenerateRequest.getWebsite());
        return passwordService.generateAndStore(passwordGenerateRequest);
    }
}
