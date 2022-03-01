package com.example.week4.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.week4.models.Art;
import com.example.week4.repositories.ArtRepository;

@Service
public class ArtService {
	@Autowired
	private ArtRepository artRepo;

//	public ArtService(ArtRepository artRepo) {
//				this.artRepo = artRepo;
//	}
	
//	All Arts
	public List<Art> getAllArts() {
		return artRepo.findAll();
	}
	
//	Create Art
	public Art createArt(Art newArt) {
		return artRepo.save(newArt);
	}
	
//	Update Art
//	Delete Art
	
	
	

	
}
