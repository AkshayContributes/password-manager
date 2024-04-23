package com.example.passwordman.service;

import com.example.passwordman.model.PasswordGenerateRequest;

public interface PasswordService {
    String generateAndStore(PasswordGenerateRequest passwordGenerateRequest, String username);

    String getPasswordForWebsiteAndUserName(PasswordGenerateRequest passwordGenerateRequest);
}
