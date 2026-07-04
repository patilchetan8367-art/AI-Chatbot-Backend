package com.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.UserRepository;
import com.dto.LoginRequest;
import com.dto.LoginResponse;
import com.entity.User;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest request) {

        Optional<User> user = userRepository.findByEmail(request.getEmail());

        if (user.isPresent()) {

            if (user.get().getPassword().equals(request.getPassword())) {

                return new LoginResponse(
                        "Login successfully!",
                        user.get().getName(),
                        user.get().getEmail());

            } else {

                return new LoginResponse(
                        "Invalid password!",
                        "",
                        "");

            }

        } else {

            return new LoginResponse(
                    "User not found!",
                    "",
                    "");

        }
    }
}