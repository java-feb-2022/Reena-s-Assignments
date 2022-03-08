package com.dojo.fitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojo.fitness.models.FitnessClass;
import com.dojo.fitness.models.Trainer;
import com.dojo.fitness.services.FitnessService;

@Controller
public class HomeController {
	@Autowired
	private FitnessService fitnessService;

	@GetMapping("/")
	public String index(Model fitnessModel) {
		
		fitnessModel.addAttribute("fitnessClasses",fitnessService.getAllClasses());
		
		return "index.jsp";
	}
//	New Trainer - Get & POST routes
	
	@GetMapping("/trainer")
	public String trainer(@ModelAttribute("newTrainer") Trainer trainer) {
		return "trainer.jsp";
	}
	
	@PostMapping("/createTrainer")
	public String createTrainer( @ModelAttribute("newTrainer") Trainer trainer) {
		fitnessService.createTrainer(trainer);
		return "redirect:/";
		
	}
	
//	New Fitness class - Get & POST routes
	
	@GetMapping("/new")
	public String newClass(
			@ModelAttribute("newClass") FitnessClass fitnessClass, 
			Model model) {
		model.addAttribute("trainers",fitnessService.getAllTrainers());
		return "fitnessClass.jsp";
	}
	
	@PostMapping("/createClass")
	public String createClass(
			@ModelAttribute("newClass") FitnessClass fitnessClass) {
		fitnessService.createClass(fitnessClass);
		return "redirect:/";
	}
	
	
}
