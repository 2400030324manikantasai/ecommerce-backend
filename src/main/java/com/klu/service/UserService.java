package com.klu.service;

import com.klu.model.User;
import com.klu.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public User login(String email, String password) {
    User user = userRepository.findByEmail(email);

    if (user != null && user.getPassword().equals(password)) {
        return user;
    } else {
        throw new RuntimeException("Invalid credentials");
    }
}
