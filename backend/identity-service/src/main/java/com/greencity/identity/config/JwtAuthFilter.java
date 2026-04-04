package com.greencity.identity.config;

import java.io.IOException;
import java.util.Collections;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.greencity.identity.infra.UserRepository;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwt;

    @Autowired
    private UserRepository userRepo;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        // 🚩 Triple check: If the path contains 'auth', DO NOT run this filter
        return path.contains("/auth/") || path.contains("/health");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {
        
        try {
            String header = req.getHeader("Authorization");
            if (header != null && header.startsWith("Bearer ")) {
                String token = header.substring(7);
                String email = jwt.extractEmail(token);

                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    var user = userRepo.findByEmail(email).orElse(null);
                    if (user != null) {
                        UsernamePasswordAuthenticationToken auth = 
                            new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
            }
        } catch (Exception e) {
            // Log it but DO NOT stop the request
            System.err.println("JWT Filter caught exception: " + e.getMessage());
        }

        chain.doFilter(req, res);
    }
}