package com.example.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.relationships.models.Person;
import com.example.relationships.repositories.PersonRepository;

@Service
public class PersonServices {
	private final PersonRepository personRepository;

	public PersonServices(PersonRepository personRepository) {

		this.personRepository = personRepository;
	}
	
	public List<Person> allPersons() {
		return personRepository.findAll();
	}

	public Person createPerson(Person person) {

		return personRepository.save(person);
	}

	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
	
	public List<Person> withoutLicensePersons() {
		return personRepository.findByLicenseIsNull();
	}

}
