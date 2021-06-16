package com.khalil.date;
import java.util.Date;  
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class DateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DateApplication.class, args);
	}

	@Controller
	@RequestMapping("/")
	public class DateController {
		@GetMapping("")
		public String home() {
			return "home.jsp";
		}

		Date dt = new Date();
		SimpleDateFormat fdate = new SimpleDateFormat("dd");  
		SimpleDateFormat fmonth = new SimpleDateFormat("MMMM"); 
		SimpleDateFormat fyear = new SimpleDateFormat("yyyy");
		SimpleDateFormat fday = new SimpleDateFormat("EEEE");
		SimpleDateFormat ftime = new SimpleDateFormat("hh:mm a"); 

		String date = fdate.format(dt);  
		String month = fmonth.format(dt);  
		String year = fyear.format(dt);  
		String day = fday.format(dt);  
		String time = ftime.format(dt);  

		@GetMapping("date")
		public String date(Model model) {
			model.addAttribute("year", year);
			model.addAttribute("month", month);
			model.addAttribute("date", date);
			model.addAttribute("day", day);

			return "date.jsp";
		}
		
		@GetMapping("time")
		public String time(Model model) {
			model.addAttribute("time", time);
			return "time.jsp";
		}

	}

}
