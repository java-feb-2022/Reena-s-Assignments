package com.example.week4.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.week4.models.Art;
import com.example.week4.services.ArtService;


@Controller

public class NftArtController {
	
	@Autowired
	private ArtService artService;
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("arts",artService.getAllArts());
		return "index.jsp";
	}
//	Add/Create 
	
	@GetMapping("/new")
	public String newArt(@ModelAttribute("art") Art art) {
		return "new.jsp";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("art") Art art, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		}
		else {
			artService.createArt(art);
			return "redirect:/";
		}
	}
	
//	Edit/Update
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		Art editArt=artService.artDetail(id);
		model.addAttribute("editArt",editArt);
		return "edit.jsp";
	}
	
	@PutMapping("/update/{id}")
	public String update(@ModelAttribute("editArt") Art art) {
		artService.updateArt(art);
		return "redirect:/";
		
	}
//Delete	
//	@GetMapping("/delete/{id}")
//	public String delete(@PathVariable Long id) {
//		artService.delete(id);
//		return "redirect:/";
//	
//	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		artService.delete(id);
		return "redirect:/";
	
	}
	
	
	
	
	

	
	
}
