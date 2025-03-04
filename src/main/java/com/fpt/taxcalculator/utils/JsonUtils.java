package com.fpt.taxcalculator.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JsonUtils {
    public <Model> Model parseFromJson(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Model> typeReference = new TypeReference<>(){};

        // Read the JSON file and map it to a List of User objects
        return objectMapper.readValue(content, typeReference);
    }
}
