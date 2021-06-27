package com.example.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.relationships.models.License;
import com.example.relationships.models.Person;
import com.example.relationships.services.LicenseServices;
import com.example.relationships.services.PersonServices;

@Controller
public class LicenseController {
	private final LicenseServices licenseService;
	private final PersonServices personService;

	public LicenseController(LicenseServices licenseService, PersonServices personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> persons = personService.withoutLicensePersons();
		model.addAttribute("persons", persons);
		return "/licenses/new.jsp";
	}
	
	@RequestMapping(value="/licenses", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute("license") License license, Model model, BindingResult result) {
		List<Person> persons = personService.withoutLicensePersons();
		model.addAttribute("persons", persons);
		if (result.hasErrors()) {
			return "/licenses/new.jsp";
		}
		String licenseNumber = licenseService.generateLicenseNumber();
		license.setNumber(licenseNumber);
		licenseService.createLicense(license);
		return "redirect:/persons/"+license.getPerson().getId();
	}
	
	
}


