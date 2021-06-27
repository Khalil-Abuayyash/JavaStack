package com.example.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.relationships.models.Person;
import com.example.relationships.services.PersonServices;

@Controller
public class PersonController {
	private final PersonServices personService;

	public PersonController(PersonServices personService) {
		this.personService = personService;
	}

	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "/Persons/newperson.jsp";
	}

	@RequestMapping(value = "/persons", method = RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if (result.hasErrors()) {
			return "/newperson.jsp";
		} else {
			personService.createPerson(person);
			return "redirect:/persons/new";
		}

	}
	
	@RequestMapping("/persons/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Person person = personService.findPerson(id);
		model.addAttribute("person", person);
		return "/Persons/show.jsp";
	}

}
