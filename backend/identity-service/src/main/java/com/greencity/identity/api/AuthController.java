package com.greencity.identity.api;

import com.greencity.identity.app.AuthService;
import com.greencity.identity.domain.User;
import com.greencity.identity.dto.LoginRequest;
import com.greencity.identity.dto.LoginResponse;
import com.greencity.identity.dto.RegisterRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/identity/auth")
public class AuthController {

    private final AuthService auth;

    public AuthController(AuthService auth) {
        this.auth = auth;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        System.out.println(">>> LOGIN HIT <<<");
        return auth.login(request);
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        return ResponseEntity.ok(auth.register(req));
    }
    @GetMapping("/users")
    public List<User> getAllUsers(){
    	return auth.getAllUsers();
    }
    
    
}