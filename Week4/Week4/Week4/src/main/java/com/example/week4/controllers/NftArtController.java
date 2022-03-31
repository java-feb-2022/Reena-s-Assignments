package com.example.week4.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.week4.models.Art;
import com.example.week4.services.ArtService;



@Controller

public class NftArtController {
	
	@Autowired
	private ArtService artService;
	private String IMAGE_FOLDER="src/main/resources/static/imgs/";

	
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
	public String create(@Valid @ModelAttribute("art") Art art, BindingResult result,@RequestParam("pic") MultipartFile file) {
		if(file.isEmpty()) {
			System.err.println("No file");
		}
		else {
			System.out.println(file.getOriginalFilename());
			try {
				byte[] bytes=file.getBytes();
				Path path=Paths.get(IMAGE_FOLDER + file.getOriginalFilename());
				FileOutputStream output = new FileOutputStream(IMAGE_FOLDER+file.getOriginalFilename());
			     output.write(file.getBytes());
				art.setArtUrl("/imgs/" + file.getOriginalFilename());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (result.hasErrors()) {
			
			return "new.jsp";
		} else {
			System.err.println(art.getArtUrl());	
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
	public String update(@Valid @ModelAttribute("editArt") Art art,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
//			return "redirect:/edit/" + id;
			
		}
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
	@GetMapping("/arts/art/{id}")
	public String project(@PathVariable("id") Long artId, Model model, HttpSession session) {
		Art art = artService.getOneArt(artId);
		model.addAttribute("art", art);
		return "art.jsp";
	}

	
	
	
	
	

	
	
}
