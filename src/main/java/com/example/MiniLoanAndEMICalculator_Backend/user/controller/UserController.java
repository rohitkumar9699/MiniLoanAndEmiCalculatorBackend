package com.example.MiniLoanAndEMICalculator_Backend.user.controller;

import com.example.MiniLoanAndEMICalculator_Backend.security.JwtUtil;
import com.example.MiniLoanAndEMICalculator_Backend.user.dto.LoginRequest;
import com.example.MiniLoanAndEMICalculator_Backend.user.dto.LoginResponse;
import com.example.MiniLoanAndEMICalculator_Backend.user.dto.SignupRequest;
import com.example.MiniLoanAndEMICalculator_Backend.user.entity.User;
import com.example.MiniLoanAndEMICalculator_Backend.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public String signup(@Valid @RequestBody SignupRequest signupRequest) {
        userService.registerUser(signupRequest);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid Credentials");
        }

        final User user = (User) userService.loadUserByUsername(loginRequest.getEmail());
        final String token = jwtUtil.generateToken(user.getUsername());

        return new LoginResponse(token);
    }
}
