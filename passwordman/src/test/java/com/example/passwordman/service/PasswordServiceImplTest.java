package com.example.passwordman.service;

import com.example.passwordman.model.PasswordDetails;
import com.example.passwordman.model.PasswordGenerateRequest;
import com.example.passwordman.repository.PasswordDetailsRepo;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordServiceImplTest {

    @Mock
    PasswordDetailsRepo passwordDetailsRepo;

    PasswordService passwordService ;

    @BeforeEach
    void setUp() {
    passwordService = new PasswordServiceImpl(passwordDetailsRepo);
    }

    @Test
    void generateAndStore() {
        PasswordGenerateRequest passwordGenerateRequest = new PasswordGenerateRequest("testWebsite", null);
        assertNotNull(passwordService.generateAndStore(passwordGenerateRequest, "testUser"));
    }


    @Test
    void getPasswordForWebsiteAndUserName() {
        PasswordGenerateRequest passwordGenerateRequest = new PasswordGenerateRequest("testUser", "testWebsite");
        PasswordDetails passwordDetails = PasswordDetails.builder().
                username("testUser").
                website("testWebsite").
                password("samplePassword").
                build();
        when(passwordDetailsRepo.findByUsernameAndWebsite(
                anyString(),
                anyString())).thenReturn(Optional.of(passwordDetails));
        assertNotNull(passwordService.getPasswordForWebsiteAndUserName(passwordGenerateRequest));
    }


}