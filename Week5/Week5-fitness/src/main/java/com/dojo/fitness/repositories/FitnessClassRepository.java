package com.dojo.fitness.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.fitness.models.FitnessClass;

@Repository
public interface FitnessClassRepository extends CrudRepository<FitnessClass, Long>{
	
 List<FitnessClass> findAll();	

}
