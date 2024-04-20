package com.example.passwordman.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordId implements Serializable {
    private String website;
    private String username;
    public PasswordId() {

    }
}
