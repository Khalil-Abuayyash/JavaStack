package com.khalil.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/")
public class RootController {
	@GetMapping("")
	public String root() {
		return "root.jsp";
	}
	
	@PostMapping("code")
	public String code(@RequestParam(value="code") String code, RedirectAttributes ra) {
		if (code.equals("bushido")) {
			return "redirect:/code";
			
		}
		else {
			ra.addFlashAttribute("wrong", "You must train harder!");
			return "redirect:/";
		}
	}
	
	@GetMapping("code")
	public String secrets() {
		return "secrets.jsp";
	}
}
