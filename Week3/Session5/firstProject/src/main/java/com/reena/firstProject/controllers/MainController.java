package com.reena.firstProject.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
//	http://localhost:8080/student
	@RequestMapping("/student")
	public String studentDetails(Model viewModel, HttpSession mySession ) {
		String name="Andrew";
		String city="WA";
		String email="Andrew@gmail.com";
		
		viewModel.addAttribute("student",name);
		viewModel.addAttribute("city",city);
		viewModel.addAttribute("email",email);
		
		mySession.setAttribute("student", name);
		return "student.jsp";
	}
//	http://localhost:8080/student/stacks
	@RequestMapping("/student/stacks")
	public String studentStacks(Model model) {
		ArrayList<String> stacks=new ArrayList<>();
		stacks.add("Java");
		stacks.add("Python");
		stacks.add("MEAN");
		model.addAttribute("myStacks",stacks);
		return "stacks.jsp";
	}
	
	

}
