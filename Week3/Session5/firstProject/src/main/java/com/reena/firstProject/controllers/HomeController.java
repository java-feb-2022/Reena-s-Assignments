package com.reena.firstProject.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
//	http://localhost:8080/
	@RequestMapping("/")
	public String index() {
		return "Hello Spring";
	}
//	http://localhost:8080/welcome
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome to Java Spring";
	}
	
//Path Variables	
//	http://localhost:8080/welcome/{student}
	@RequestMapping("/welcome/{name}/{stack}")
	public String welcomeStudent(@PathVariable String name,
			@PathVariable String stack) {
		return "Welcome to " + stack + " , "+  name;
	}
	
//	Request Params
	@RequestMapping("/codingDojo")
	public String codingdojo(@RequestParam String name, @RequestParam String stack) {
		return "Welcome to " + stack + " , "+  name; 
	}
	
	
	
	
	
	
	
	

	
}
