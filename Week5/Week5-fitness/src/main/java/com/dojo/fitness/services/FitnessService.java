package com.dojo.fitness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.fitness.models.FitnessClass;
import com.dojo.fitness.models.Trainer;
import com.dojo.fitness.repositories.FitnessClassRepository;
import com.dojo.fitness.repositories.TrainerRepository;

@Service
public class FitnessService {
	@Autowired
	private FitnessClassRepository fitnessRepo;
	
	@Autowired
	private TrainerRepository trainerRepo;
	
//	All Trainers
	public List<Trainer> getAllTrainers(){
		return trainerRepo.findAll();
	}
//	Create Trainer
	public Trainer createTrainer(Trainer trainer) {
		return trainerRepo.save(trainer);
	}
//	All Fitness Classes
	public List<FitnessClass> getAllClasses(){
		return this.fitnessRepo.findAll();
	}
//	Create Fitness Class
	public FitnessClass createClass(FitnessClass fitnessClass) {
		return fitnessRepo.save(fitnessClass);
		
	}
	

}
