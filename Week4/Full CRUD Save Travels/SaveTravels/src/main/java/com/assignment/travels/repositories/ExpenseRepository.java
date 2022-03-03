package com.assignment.travels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.travels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>  {
	
	// this method retrieves all the arts from the database
    List<Expense> findAll();
	

}
