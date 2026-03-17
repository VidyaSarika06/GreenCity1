package com.greencity.identity.app;

import com.greencity.identity.config.JwtUtil;
import com.greencity.identity.domain.User;
import com.greencity.identity.dto.LoginRequest;
import com.greencity.identity.dto.LoginResponse;
import com.greencity.identity.infra.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwt;

    public AuthService(UserRepository repo, PasswordEncoder encoder, JwtUtil jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    public LoginResponse login(LoginRequest request) {
    	
    	// Run this once to get the correct string
    	System.out.println("NEW HASH FOR Pass@123: " + encoder.encode("Pass@123"));
        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        // 🔥 DEBUG LOGS TO SEE EXACT PROBLEM
        System.out.println(">>> DEBUG LOGIN <<<");
        System.out.println("Typed password: " + request.getPassword());
        System.out.println("DB hash      : " + user.getPasswordHash());
        System.out.println("Matches?     : " + encoder.matches(request.getPassword(), user.getPasswordHash()));
        System.out.println("Password length: " + request.getPassword().length());
        
        if (!encoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwt.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return new LoginResponse(token);
    }
}