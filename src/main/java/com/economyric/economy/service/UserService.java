package com.economyric.economy.service;


import com.economyric.economy.domain.User;
import com.economyric.economy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        userRepository.save(user);
        return user;
    }

    private User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User login(String email, String senha) {
        User user = userRepository.findByEmail(email);
        if (senha.equals(user.getSenha())) {
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userRepository.save(user);
            return user;
        }
        else {
            return null;
        }
    }
}

