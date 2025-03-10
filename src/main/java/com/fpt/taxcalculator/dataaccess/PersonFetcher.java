package com.fpt.taxcalculator.dataaccess;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.utils.JsonUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
public class PersonFetcher {
	public List<Person> getAllPersons() throws JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		String GITHUB_URL = "https://raw.githubusercontent.com/tnav1999/tax-calculator/refs/heads/main/datastore/users.json";
		String response = restTemplate.getForObject(GITHUB_URL, String.class);

		ObjectMapper objectMapper = new ObjectMapper();
		TypeReference<List<Person>> typeReference = new TypeReference<>(){};

		return objectMapper.readValue(response, typeReference);
	}
}
