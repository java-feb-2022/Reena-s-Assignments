package com.example.week4.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.week4.models.Art;

@Repository
public interface ArtRepository extends CrudRepository<Art, Long>  {
	
	// this method retrieves all the arts from the database
    List<Art> findAll();
    
	

}
