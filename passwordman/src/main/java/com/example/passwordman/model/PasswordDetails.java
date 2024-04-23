package com.example.passwordman.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "password_details")
@Data
@IdClass(PasswordId.class)
public class PasswordDetails {
    @Id
    private String website;
    @Id
    private String username;
    private String password;
}
