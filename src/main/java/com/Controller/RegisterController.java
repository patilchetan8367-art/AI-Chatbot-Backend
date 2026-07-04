package com.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Repository.UserRepository;
import com.dto.RegisterRequest;
import com.entity.User;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        System.out.println("Email received: " + request.getEmail());

        Optional<User> existingUser = userRepository.findByEmail(request.getEmail());

        System.out.println("User found: " + existingUser.isPresent());

        if (existingUser.isPresent()) {
            return "Email already exists!";
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return "User registered successfully!";
    }
    }
