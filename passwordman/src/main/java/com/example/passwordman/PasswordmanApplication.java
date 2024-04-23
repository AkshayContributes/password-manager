package com.example.passwordman;

import com.example.passwordman.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class PasswordmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordmanApplication.class, args);
	}

}
