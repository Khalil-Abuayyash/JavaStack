package com.khalil.ninjagoldgame.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GoldController {

	private void g(HttpSession session, String place) {
		Integer gold = (Integer) session.getAttribute("gold");
		ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
		String activity;
		Integer rn;
		Date dt = new Date();
		SimpleDateFormat f = new SimpleDateFormat("MMMM dd YYYY hh:mm a");
		String date = f.format(dt); 
		
		if (place.equals("farm")) {	
			rn = (Integer) (int) Math.floor(Math.random()*10+10);
			activity = String.format("You entered a farm and earned %d gold." , rn);
		}
		else if (place.equals("cave")) {
			rn = (Integer) (int) Math.floor(Math.random()*5+5);
			activity = String.format("You entered a cave and earned %d gold." , rn);
		}
		else if (place.equals("house")) {
			rn = (Integer) (int) Math.floor(Math.random()*3+2);
			activity = String.format("You entered a house and earned %d gold." , rn);
		}
		else {
			rn = (Integer) (int) Math.floor(Math.random()*100-50);
			if (rn >= 0) {
				activity = String.format("You entered a casino and earned %d gold." , rn);
			}
			else {
				activity = String.format("You entered a casino and lost %d gold." , rn);
			}
			
		}
		gold = gold + rn ;
		session.setAttribute("gold", gold);
		activity += String.format(" %s", date);
		activities.add(activity);
		session.setAttribute("activities", activities);
	}
	
	@GetMapping("gold")
	public String game(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities", new ArrayList<String>());
		}
		return "gold.jsp";
	}
	
	@PostMapping("gold")
	public String findGold(@RequestParam(value="place") String place, HttpSession session) {
		g(session, place);
		return "redirect:/gold";
	}
}
