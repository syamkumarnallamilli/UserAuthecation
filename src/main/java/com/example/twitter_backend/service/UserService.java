package com.example.twitter_backend.service;

import org.springframework.stereotype.Service;

import com.example.twitter_backend.model.User;
import com.example.twitter_backend.repository.UserRepository;

import org.mindrot.jbcrypt.BCrypt;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User();
        user.setUsername(username);
        user.setPasswordHash(hashedPassword);
        return userRepository.save(user);
    }

    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        return user != null && BCrypt.checkpw(password, user.getPasswordHash());
    }
}
