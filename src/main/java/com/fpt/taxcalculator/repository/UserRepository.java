package com.fpt.taxcalculator.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fpt.taxcalculator.model.User;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepository {
    private final JsonUtils jsonUtils;

    public UserRepository(JsonUtils jsonUtils) {
        this.jsonUtils = jsonUtils;
    }

    public List<User> findAll() throws IOException {
        return getAllUsers();
    }

    public User findByUserId(Long userId) throws IOException {
        List<User> users = getAllUsers();
        Optional<User> foundUser = users.stream().filter(user -> user.getId().equals(userId)).findFirst();

        if (foundUser.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return foundUser.get();
    }

    public List<User> getAllUsers() throws IOException {
        String filePath = "datastore/users.json";  // specify the path to your JSON file
        TypeReference<List<User>> typeRef = new TypeReference<>() {};
        return jsonUtils.parseFromJson(filePath, typeRef);
    }
}
