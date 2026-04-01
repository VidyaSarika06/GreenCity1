/*package com.greencity.identity.app;

import com.greencity.identity.config.JwtUtil;
import com.greencity.identity.domain.User;
import com.greencity.identity.dto.LoginRequest;
import com.greencity.identity.dto.LoginResponse;
import com.greencity.identity.dto.RegisterRequest;
import com.greencity.identity.infra.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthService {
	@Autowired
	private AuditService audit;

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
        audit.audit("User Login", "User", user.getUserId());

        String token = jwt.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return new LoginResponse(token);
    }
    public LoginResponse register(RegisterRequest req) {

        if (userRepo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPasswordHash(encoder.encode(req.getPassword()));
        user.setRole(Role.CITIZEN);
        user.setStatus(UserStatus.ACTIVE);
        userRepo.save(user);

        audit("User Registered", "User", user.getUserId());

        return new LoginResponse("Registered Successfully");
    }
}*/

package com.greencity.identity.app;

import com.greencity.identity.config.JwtUtil;
import com.greencity.identity.domain.User;
import com.greencity.identity.domain.Role;
import com.greencity.identity.domain.UserStatus;
import com.greencity.identity.dto.LoginRequest;
import com.greencity.identity.dto.LoginResponse;
import com.greencity.identity.dto.RegisterRequest;
import com.greencity.identity.infra.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthService {

    @Autowired
    private AuditService audit;

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwt;

    public AuthService(UserRepository repo, PasswordEncoder encoder, JwtUtil jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    //Login
    public LoginResponse login(LoginRequest request) {

        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        // Debugging values
        System.out.println(">>> DEBUG LOGIN <<<");
        System.out.println("Typed password: " + request.getPassword());
        System.out.println("DB hash      : " + user.getPasswordHash());
        System.out.println("Matches?     : " + encoder.matches(request.getPassword(), user.getPasswordHash()));

        if (!encoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        // Audit log
        audit.audit("User Login", "User", user.getId());

        // Generate token
        String token = jwt.generateToken(user.getEmail(), user.getRole().name());

        return new LoginResponse(token);
    }


 //Register
    public LoginResponse register(RegisterRequest req) {

        if (repo.existsByEmail(req.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPasswordHash(encoder.encode(req.getPassword()));
        user.setRole(Role.Citizen);
     // Change the hardcoded "Citizen" to use the request data:
       // user.setRole(registrationRequest.getRole());
        user.setStatus(UserStatus.Active);

        repo.save(user);

        // Audit log
        audit.audit("User Registered", "User", user.getId());

        return new LoginResponse("Registered Successfully");
    }
    //User
    public List<User> getAllUsers(){
    	return repo.findAll();
    }
}