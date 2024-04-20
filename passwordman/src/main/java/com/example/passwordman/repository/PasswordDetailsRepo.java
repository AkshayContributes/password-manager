package com.example.passwordman.repository;

import com.example.passwordman.model.PasswordDetails;
import java.util.Optional;
import javax.swing.JPasswordField;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordDetailsRepo extends JpaRepository<PasswordDetails, Long> {
    Optional<PasswordDetails> findByUsernameAndWebsite(String username, String website);
}
