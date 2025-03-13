package com.fpt.taxcalculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.dataaccess.PersonFetcher;
import com.fpt.taxcalculator.model.SearchPersonRequest;
import com.fpt.taxcalculator.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

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
		Person person = personRepository.findPersonByLastname(lastName);

		if (Objects.isNull(person)) {
			throw new EntityNotFoundException("Person with provided last name is not found");
		}

		return person;
	}

	public List<Person> search(SearchPersonRequest request) {
		return personRepository.findByFirstNameAndLastName(request.getFirstName(), request.getLastName());
	}

	public List<Person> getPersons() {
		try {
			return personFetcher.getAllPersons();
		} catch (JsonProcessingException ex) {
			throw new IllegalStateException("Cannot parse person data");
		}
	}
}
