package com.example.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.authentication.models.User;
import com.example.authentication.services.UserService;
import com.example.authentication.validators.UserValidator;

@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
    
    public UserController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
    	if (result.hasErrors()) {
    		return "registrationPage.jsp";
    	}
    	
        // else, save the user in the database, save the user id in session, and redirect them to the /home route
    	user = userService.registerUser(user);
    	session.setAttribute("id", user.getId());
    	return "redirect:/home";
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
    	if (userService.authenticateUser(email, password)) {
    		User user = userService.findByEmail(email);
    		session.setAttribute("id", user.getId());
    		return "redirect:/home";
    	}
        // else, add error messages and return the login page
    	model.addAttribute("error", "Invalid Credentials. please try again.");
    	return "loginPage.jsp";
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    	Long id = (Long) session.getAttribute("id");
    	User user = userService.findUserById(id);
    	model.addAttribute("user", user);
    	return "homePage.jsp";
    }
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
    	session.invalidate();
        // redirect to login page
    	return "redirect:/login";
    }
}
