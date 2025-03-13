package com.fpt.taxcalculator.controller;

import com.fpt.taxcalculator.model.Person;
import com.fpt.taxcalculator.model.SearchPersonRequest;
import com.fpt.taxcalculator.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/search")
	public List<Person> search(@RequestBody @Valid SearchPersonRequest request) {
		return personService.search(request);
	}
}
