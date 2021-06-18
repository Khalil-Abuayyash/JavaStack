package com.khalil.dojosurvey.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class surveyController {
	@GetMapping
	public String showForm() {
		return "survey.jsp";
	}
	
	@PostMapping("result")
	public String submit(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language")String language, @RequestParam(value="comment") String comment, HttpSession session) {
		session.setAttribute("name", name);
		session.setAttribute("language", language);
		session.setAttribute("location", location);
		session.setAttribute("comment", comment);
		return ("redirect:/result");
	}
	
	@GetMapping("result")
	public String submitted() {
		return "info.jsp";
	}
}
