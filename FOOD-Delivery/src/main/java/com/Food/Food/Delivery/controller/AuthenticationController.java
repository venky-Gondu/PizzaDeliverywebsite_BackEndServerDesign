package com.Food.Food.Delivery.controller;

import com.Food.Food.Delivery.dto.AuthRequestDTO;
import com.Food.Food.Delivery.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final UserService userService;

    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    // ✅ Register a new user
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequestDTO request) {
        String response = userService.registerUser(request.getUsername(), request.getLname(), request.getEmail(), request.getPassword());
        return ResponseEntity.ok(response);
    }

    // ✅ User login verification
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequestDTO request) {
        boolean validUser = userService.verifyUser(request.getEmail(), request.getPassword());
        if (validUser) {
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(401).body("Invalid email or password");
    }

}