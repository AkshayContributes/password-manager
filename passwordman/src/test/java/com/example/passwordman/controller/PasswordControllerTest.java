package com.example.passwordman.controller;

import com.example.passwordman.model.PasswordGenerateRequest;
import com.example.passwordman.service.PasswordService;
import java.security.Principal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordControllerTest {

    @Mock
    PasswordService passwordService;
    PasswordController passwordController;


    @BeforeEach
    public void setup(){
        passwordController = new PasswordController(passwordService);
    }

    @Test
    void generatePassword() {
        PasswordGenerateRequest passwordGenerateRequest = new PasswordGenerateRequest("testWebsite", null);
        when(passwordService.generateAndStore(passwordGenerateRequest, "testUser")).thenReturn("samplePassword");
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return "testUser";
            }
        };

        assertEquals("samplePassword", passwordController.generatePassword(passwordGenerateRequest, principal));
    }

    @Test
    void getPassword() {
        PasswordGenerateRequest passwordGenerateRequest = new PasswordGenerateRequest("testUser", "testWebsite");
        when(passwordService.getPasswordForWebsiteAndUserName(passwordGenerateRequest)).thenReturn("samplePassword");
        assertEquals("samplePassword", passwordController.getPassword(passwordGenerateRequest));
    }
}