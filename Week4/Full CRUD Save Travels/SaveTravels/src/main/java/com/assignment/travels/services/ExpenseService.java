package com.assignment.travels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.travels.models.Expense;
import com.assignment.travels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	private ExpenseRepository artRepo;

//	public ExpenseService(ExpenseRepository artRepo) {
//				this.artRepo = artRepo;
//	}
	
//	All Arts
	public List<Expense> getAllArts() {
		return artRepo.findAll();
	}
	
//	Create Expense
	public Expense createArt(Expense newArt) {
		return artRepo.save(newArt);
	}
	
//	Update Expense
	public Expense update(Expense expense) {
		return artRepo.save(expense);
	}
	
//	Delete Expense
	public void delete(Long id) {
		artRepo.deleteById(id);
	}
//	Get One Expense
	public Expense getExpense(Long id) {
		return artRepo.findById(id).orElse(null);
	}
	
	
	

	
}
