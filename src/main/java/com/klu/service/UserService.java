package com.klu.service;

import com.klu.model.User;
import com.klu.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ Signup
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // ✅ Login (FIXED)
    public User login(String email, String password) {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
