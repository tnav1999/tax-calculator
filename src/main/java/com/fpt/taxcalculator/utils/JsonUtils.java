package com.fpt.taxcalculator.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class JsonUtils {
    public <Response> Response parseFromJson(String content, TypeReference<Response> typeReference) throws IOException {
        // Create an ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Read the JSON file and map it to a List of User objects
        return objectMapper.readValue(content, typeReference);
    }
}
