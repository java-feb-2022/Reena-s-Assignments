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
//	ArtDetails
	public Art artDetail(Long id) {
		return artRepo.findById(id).orElse(null);
	}
	
//	Update Art
	public Art updateArt(Art upadtedArt) {
		return artRepo.save(upadtedArt);
	}
	
//	Delete Art
	public void delete(Long id) {
		artRepo.deleteById(id);
	}
	

	
}
