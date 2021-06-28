package com.khalil.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khalil.dojooverflow.models.Answer;
import com.khalil.dojooverflow.models.Question;
import com.khalil.dojooverflow.models.RegexQuestion;
import com.khalil.dojooverflow.services.QuestionService;

@Controller
@RequestMapping("/questions")
public class QuestionController {
	private final QuestionService questionService;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@GetMapping("")
	public String dashboard(Model model) {
		List<Question> questions = questionService.allQuestions();
		model.addAttribute("questions", questions);
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String newQuestion(@ModelAttribute("q") RegexQuestion q) {
		return "new.jsp";
	}
	
	@PostMapping("")
	public String createQuestion(@Valid @ModelAttribute("q")RegexQuestion q, BindingResult result) {
		if (result.hasErrors()) {
			return "new.jsp";
		}
		//Tags Validation
		questionService.createQuestion(q);
		return "redirect:/questions";
	}
	
	@GetMapping("/{id}")
	public String showQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("an") Answer an) {
		Question question = questionService.findQuestionById(id);
		model.addAttribute("question", question);
		return "answer.jsp";
	}
	
	@PostMapping("/{id}")
	public String addAnswer(@PathVariable("id") Long id, @Valid @ModelAttribute("an") Answer an, BindingResult result) {
		if (result.hasErrors()) {
			return "answer.jsp";
		}
		questionService.addAnswer(an, id);
		return "redirect:/questions";
	}
}
