package com.opd_management.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEncoderConfig {

	// This method creates a PasswordEncoder bean
    // It is used to encrypt and verify passwords securely
    @Bean
    public PasswordEncoder passwordEncoder() {
        
        // BCryptPasswordEncoder uses BCrypt hashing algorithm
        // to store passwords in encrypted (hashed) form
        return new BCryptPasswordEncoder();
    }
}
