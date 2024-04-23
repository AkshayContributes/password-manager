package com.example.passwordman.service;

import com.example.passwordman.model.PasswordDetails;
import com.example.passwordman.model.PasswordGenerateRequest;
import com.example.passwordman.repository.PasswordDetailsRepo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PasswordServiceImpl implements PasswordService {


    PasswordDetailsRepo passwordDetailsRepo;

    public PasswordServiceImpl(PasswordDetailsRepo passwordDetailsRepo) {
        this.passwordDetailsRepo = passwordDetailsRepo;
    }


    private static final String CAPS_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String SMALL_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()";
    private static final String PASSWORD_CHARS = CAPS_CHARS + SMALL_CHARS + NUMBERS + SPECIAL_CHARS;

    @Override
    public String generateAndStore(final PasswordGenerateRequest passwordGenerateRequest, String username) {


        String password = passwordGenerateRequest.getPassword();

        if (password == null) {
            password = generate(passwordGenerateRequest);
        }

        PasswordDetails passwordDetails = PasswordDetails.builder().
                username(username).
                website(passwordGenerateRequest.getWebsite()).
                password(password).
                build();
        store(passwordDetails);
        return password;
    }

    @Override
    public String getPasswordForWebsiteAndUserName(PasswordGenerateRequest passwordGenerateRequest) {
        Optional<PasswordDetails> password
                = passwordDetailsRepo.findByUsernameAndWebsite(passwordGenerateRequest.getUsername(),
                                                                passwordGenerateRequest.getWebsite());
        return password.orElseThrow().getPassword();
    }

    private String generate(final PasswordGenerateRequest passwordGenerateRequest) {
        Random random = new Random();
        int length = random.nextInt(12, 15);
        int caps = random.nextInt(1, 3);
        int small = random.nextInt(1, 3);
        int numbers = random.nextInt(1, 3);
        int special = random.nextInt(1, 3);
        int remaining = length - (caps + small + numbers + special);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < caps; i++) {
            sb.append(CAPS_CHARS.charAt(random.nextInt(CAPS_CHARS.length())));
        }
        for (int i = 0; i < small; i++) {
            sb.append(SMALL_CHARS.charAt(random.nextInt(SMALL_CHARS.length())));
        }
        for (int i = 0; i < numbers; i++) {
            sb.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }
        for (int i = 0; i < special; i++) {
            sb.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));
        }
        for (int i = 0; i < remaining; i++) {
            sb.append(PASSWORD_CHARS.charAt(random.nextInt(PASSWORD_CHARS.length())));
        }

        ArrayList<Character> characters = new ArrayList<>();

        for(Character c: sb.toString().toCharArray()) {
           characters.add(c);
        }

        Collections.shuffle(characters);

        log.info("Generated password of length: {}", length);

        return characters.stream().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    private void store(final PasswordDetails passwordDetails) {
        passwordDetailsRepo.save(passwordDetails);
    }
}
