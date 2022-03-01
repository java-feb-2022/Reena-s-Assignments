package com.reena.secProject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
//	@RequestMapping("/")
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
//	@RequestMapping("/results")
//	@RequestMapping(value="/results", method=RequestMethod.POST)
	
	@PostMapping("/results")
	public String results(@RequestParam String firstName,
			@RequestParam String email,
			@RequestParam String program, Model viewModel ) {
		viewModel.addAttribute("firstName",firstName);
		viewModel.addAttribute("email",email);
		viewModel.addAttribute("program",program);
		return "results.jsp";
	}

}
