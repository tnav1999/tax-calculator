package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.model.User;
import com.fpt.taxcalculator.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() throws IOException {
        return userRepository.findAll();
    }

    public User findById(Long userId) throws IOException {
        return userRepository.findByUserId(userId);
    }
}
