package com.greencity.identity.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class JwtUtil {

    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.issuer}")
    private String issuer;

    @Value("${app.jwt.expirationMinutes}")
    private int expirationMinutes;

    
    // create signing key
    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    //     GENERATE TOKEN
   
    public String generateToken(String subject, String role) {
        Instant now = Instant.now();

        return Jwts.builder()
                .setSubject(subject)
                .claim("role", role)
                .setIssuer(issuer)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(expirationMinutes, ChronoUnit.MINUTES)))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    //     EXTRACT EMAIL

    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    //     EXTRACT ROLE

    public String extractRole(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("role", String.class);
    }
}