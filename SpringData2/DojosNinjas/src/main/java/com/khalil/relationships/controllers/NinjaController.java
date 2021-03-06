package com.khalil.relationships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khalil.relationships.models.Dojo;
import com.khalil.relationships.models.Ninja;
import com.khalil.relationships.services.DojoService;
import com.khalil.relationships.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	
	public NinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@GetMapping("new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model model) {
		List<Dojo> dojos = dojoService.allDojos();
		model.addAttribute("dojos", dojos);
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("")
	public String createNinja(@Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		System.out.println(ninja.getDojo());
		if(result.hasErrors()) {
			return "/ninjas/new.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
}
