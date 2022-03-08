package com.assignment.travels.controllers;

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

import com.assignment.travels.models.Expense;
import com.assignment.travels.services.ExpenseService;


@Controller

public class HomeController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/")
	public String index(Model viewModel,@ModelAttribute("newExpense") Expense newExpense) {
		viewModel.addAttribute("expenses",expenseService.getAllArts());
		return "index.jsp";
	}
	
	@PostMapping("/expense")
	public String create(@Valid @ModelAttribute("newExpense") Expense newExpense, BindingResult result, Model viewModel ) {
		if(result.hasErrors()) {
			viewModel.addAttribute("expenses",expenseService.getAllArts());
			return "index.jsp";
		}
		expenseService.createArt(newExpense);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model viewModel) {
		Expense editExpense=expenseService.getExpense(id);
		viewModel.addAttribute("editExpense",editExpense);
		return "edit.jsp";
	}
	@PutMapping("/update/{id}")
	public String update(@Valid @ModelAttribute Expense editExpense, BindingResult result, Model viewModel,@PathVariable Long id ) {
		if(result.hasErrors()) {
			viewModel.addAttribute("editExpense",expenseService.getExpense(id));
			return "edit.jsp";
		}
		expenseService.update(editExpense);
		return "redirect:/";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		expenseService.delete(id);
		return "redirect:/";
		
	}
	
	

}
