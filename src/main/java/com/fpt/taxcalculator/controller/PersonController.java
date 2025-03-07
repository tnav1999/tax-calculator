package com.fpt.taxcalculator.controller;

import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService userService;

    public PersonController(PersonService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Person> callGetUser() throws IOException {
        return userService.getUsers();
    }
}
