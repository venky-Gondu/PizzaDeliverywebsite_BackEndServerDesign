package com.Food.Food.Delivery.services;

import com.Food.Food.Delivery.Model.User;
import com.Food.Food.Delivery.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (!userOpt.isPresent()) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        User user = userOpt.get();

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>() // Empty authorities list for now
        );
    }

    public String registerUser(String username, String lname, String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            return "Email already exists!";
        }

        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(username, lname, email, hashedPassword);
        userRepository.save(user);

        return "User registered successfully!";
    }

    public boolean verifyUser(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}