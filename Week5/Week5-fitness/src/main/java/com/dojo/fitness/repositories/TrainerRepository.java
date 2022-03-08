package com.dojo.fitness.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.fitness.models.FitnessClass;
import com.dojo.fitness.models.Trainer;

@Repository
public interface TrainerRepository extends CrudRepository<Trainer, Long>{
	
 List<Trainer> findAll();	

}
