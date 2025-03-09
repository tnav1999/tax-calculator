package com.fpt.taxcalculator.service;

import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.dataaccess.PersonFetcher;
import com.fpt.taxcalculator.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PersonService {
    private final PersonFetcher personFetcher;
	private final PersonRepository personRepository;

    public PersonService(PersonFetcher personFetcher, PersonRepository personRepository) {
        this.personFetcher = personFetcher;
		this.personRepository = personRepository;
	}

    public List<Person> getPerson() throws IOException {
        return personFetcher.findAll();
    }

    public Person findById(Long userId)  {
        return personRepository.getPersonById(userId);
    }

	public List<Person> getAllPersonFromDB() {
		return personRepository.findAllByOrderByIncomeDesc();
	}
}
