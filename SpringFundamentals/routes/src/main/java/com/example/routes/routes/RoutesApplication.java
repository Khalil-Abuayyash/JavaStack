package com.example.routes.routes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication


public class RoutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutesApplication.class, args);
	}

	
	@RestController
	@RequestMapping("/coding")
	public class CodingController {
		@RequestMapping("")
		public String coding() {
			return "Hello Coding Dojo!";
		}
		@RequestMapping("/python")
		public String python() {
			return "Python/Django was awesome!";
		}
		@RequestMapping("java")
		public String java() {
			return "Java/Spring is better!";
		}
	}
	
	@RestController
	@RequestMapping("/")
	public class DojoController {
		@RequestMapping("{name}")
		public String d(@PathVariable("name") String name) {
			if (name.compareTo("dojo") == 0) {
				return "The" +  name + "is awesome!";
			}
			else if (name.compareTo("burbank-dojo") == 0) {
				return "Burbank Dojo is located in Southern California'.";
			}
			else if (name.compareTo("san-jose") == 0) {
				return "SJ dojo is the headquarters";
			}
			else {
				return "strange";
			}
			// return "The" +  name + "is awesome!";
		}
	}
}
