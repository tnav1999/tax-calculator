package com.fpt.taxcalculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.dataaccess.PersonFetcher;
import com.fpt.taxcalculator.repository.PersonRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Component
public class PersonService {
	private final PersonFetcher personFetcher;
	private final PersonRepository personRepository;

	public PersonService(PersonFetcher personFetcher, PersonRepository personRepository) {
		this.personFetcher = personFetcher;
		this.personRepository = personRepository;
	}

	public List<Person> getPersonOrderByIncome(){
		return personRepository.findAllByOrderByIncome();
	}

	public Person getPersonByLastName(String lastName){
		return personRepository.findPersonByLastname(lastName);
	}

	public List<Person> getPersons() {
		try {
			return personFetcher.getAllPersons();
		} catch (JsonProcessingException ex) {
			throw new IllegalStateException("Cannot parse person data");
		}
	}
}
