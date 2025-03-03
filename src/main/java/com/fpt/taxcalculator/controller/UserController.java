package com.fpt.taxcalculator.controller;

import com.fpt.taxcalculator.model.User;
import com.fpt.taxcalculator.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> callGetUser() throws IOException {
        return userService.getUsers();
    }
}
