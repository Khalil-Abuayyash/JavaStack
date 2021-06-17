package com.khalil;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/")
public class counterController {
	
	@RequestMapping("")
	public String welcome(HttpSession session, Model model) {
		
        if (session.getAttribute("counter") == null) {
            session.setAttribute("counter", 0);
        }
        else {
            Integer counter = (Integer) session.getAttribute("counter"); 
            session.setAttribute("counter", counter + 1);
        }
//        return String.format("%s", session.getAttribute("counter"));
        model.addAttribute("counter", session.getAttribute("counter"));
        return "index.jsp";
    }
	
	@GetMapping("counter")
	public String counter() {
		return "counter.jsp";
	}
	
}
