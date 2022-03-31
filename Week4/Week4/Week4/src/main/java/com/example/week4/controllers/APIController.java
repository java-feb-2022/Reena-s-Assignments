package com.example.week4.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.week4.models.Art;
import com.example.week4.services.ArtService;

@RestController
public class APIController {
	@Autowired
	private ArtService artService;
	
	@GetMapping("/apis/arts")
	public List<Art> arts(){
		return artService.getAllArts();
	}
//	Create an Art
	@PostMapping("/apis/create")
	public Art createArt(@Valid @ModelAttribute("art") Art art, BindingResult result) {
		if(result.hasErrors()) {
				return null;
		}
		else {
			return  artService.createArt(art);
			
		}
	}
//	Update Art
	@PutMapping("/apis/update/{id}")
	public Art updateArt(@ModelAttribute("art") Art art) {
		return artService.updateArt(art);
	}
	
//	Delete Art
	@DeleteMapping("/apis/delete/{id}")
	public String deleteArt(@PathVariable Long id) {
		 artService.delete(id);
		 return "Sucessfully deleted";
	}
	
	
	
	
	
	

}
