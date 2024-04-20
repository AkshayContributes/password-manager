package com.example.passwordman.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PasswordGenerateRequest {
    @NotBlank(message = "Website is mandatory")
    private String website;

    @NotBlank(message = "Username is mandatory")
    private String username;

    private String password;


    public PasswordGenerateRequest(String website, String username) {
        this.website = website;
        this.username = username;
    }

}
