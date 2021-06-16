package com.khalil.homecontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class HomecontrollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomecontrollerApplication.class, args);
	}

	@Controller
	public class HomeController {
    	@RequestMapping("/")
		public String index(Model model) {
			model.addAttribute("dojoName", "Burbank");
			return "index.jsp";
		}
	}
}
