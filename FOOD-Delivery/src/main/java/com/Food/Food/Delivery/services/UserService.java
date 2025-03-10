package com.Food.Food.Delivery.services;

import com.Food.Food.Delivery.Model.User;
import com.Food.Food.Delivery.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(String username, String lname, String email, String password) {
        if (userRepository.findByEmail(email).isPresent()) {
            return "Email already exists!";
        }

        String hashedPassword = String.valueOf(password.hashCode());
        User user = new User(username, lname, email, hashedPassword);
        userRepository.save(user);

        return "User registered successfully!";
    }

    public boolean verifyUser(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return Objects.equals(user.getPassword(), String.valueOf(password.hashCode()));
        }
        return false;
    }
}