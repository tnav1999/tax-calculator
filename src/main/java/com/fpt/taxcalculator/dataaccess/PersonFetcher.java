package com.fpt.taxcalculator.dataaccess;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.utils.JsonUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class PersonFetcher {
    private final JsonUtils jsonUtils;
    private final RestTemplate restTemplate;

    public PersonFetcher(JsonUtils jsonUtils) {
        this.jsonUtils = jsonUtils;
        this.restTemplate = new RestTemplate();
    }

    public List<Person> findAll() throws IOException {
        return getAllUsers();
    }

    public Person findByUserId(Long userId) throws IOException {
        List<Person> users = getAllUsers();
        Optional<Person> foundUser = users.stream().filter(user -> user.getId().equals(userId)).findFirst();

        if (foundUser.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return foundUser.get();
    }

    public List<Person> getAllUsers() throws IOException {
        String GITHUB_URL = "https://raw.githubusercontent.com/tnav1999/tax-calculator/refs/heads/main/datastore/users.json";
        String response = restTemplate.getForObject(GITHUB_URL, String.class);

        TypeReference<List<Person>> typeRef = new TypeReference<>() {};
        return jsonUtils.parseFromJson(response, typeRef);
    }
}
