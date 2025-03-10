package com.fpt.taxcalculator.controller;

import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping
	public List<Person> getAllPersons() {
		return personService.getPersonOrderByIncome();
	}

	@GetMapping("/")
	public Person getPersonByLastName(@RequestParam String lastName){
		return personService.getPersonByLastName(lastName);
	}
}
