package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.dataaccess.PersonFetcher;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonService {
    private final PersonFetcher personFetcher;

    public PersonService(PersonFetcher userRepository) {
        this.personFetcher = userRepository;
    }

    public List<Person> getUsers() throws IOException {
        return personFetcher.findAll();
    }

    public Person findById(Long userId) throws IOException {
        return personFetcher.findByUserId(userId);
    }
}
