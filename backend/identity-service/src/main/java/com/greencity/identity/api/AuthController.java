package com.greencity.identity.api;

import com.greencity.identity.app.AuthService;
import com.greencity.identity.dto.LoginRequest;
import com.greencity.identity.dto.LoginResponse;
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
    
    
}