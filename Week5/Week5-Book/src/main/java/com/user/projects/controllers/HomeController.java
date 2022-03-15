package com.user.projects.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.projects.models.Book;
import com.user.projects.models.LoginUser;
import com.user.projects.models.Ratings;
import com.user.projects.models.User;
import com.user.projects.services.UserService;
import com.user.projects.services.bookService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private bookService bookService;
	

	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User user, 			@ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}

// ************Register a User***************
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("newUser") User user,
			BindingResult result, HttpSession session, 
			@ModelAttribute("newLogin") LoginUser loginUser
			) {
//		Validate user
		userService.validate(user, result);
		if(result.hasErrors()) {
			 
	            List<FieldError> fieldErrors = result.getFieldErrors();
	            for (FieldError error : fieldErrors ) {
	                System.out.print(error.getDefaultMessage());
	              } 
			System.out.println();
			return "index.jsp";
		}
//		Register User
		userService.registerUser(user);
//		Put User in Session
		session.setAttribute("loggedInUser", user);
		return "redirect:/dashboard";
	}

//******************Login********************
	@PostMapping("/login")
	public String loginUser(
			@Valid @ModelAttribute("newLogin") LoginUser loginuser, 
			BindingResult results, 
			HttpSession session,  
			@ModelAttribute("newUser") User user) {
		// Authenticate User
		userService.authenticateUser(loginuser, results);
		if(results.hasErrors()) {
			return "index.jsp";
		}
		User loggedInUser=userService.findByEmail(loginuser.getEmail());
		// Put User in Session
		session.setAttribute("loggedInUser", loggedInUser);
		return "redirect:/dashboard";
	}

//****************Logout*********************
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
//		Check if user is in session
		if(session.getAttribute("loggedInUser")!=null) {
			User user=(User)session.getAttribute("loggedInUser");
			model.addAttribute("books",bookService.getBooksByBorrower(user));
			model.addAttribute("availableBooks",bookService.getAvilable(user));
			
			return "dashboard.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
//	**************************************Book Routes********************************
	
//	New Fitness class - Get & POST routes
	
	@GetMapping("/new")
	public String newBook(
			@ModelAttribute("newBook") Book book, 
			Model model) {
		return "new.jsp";
	}
	
	@PostMapping("/createBook")
	public String createBook(
			@ModelAttribute("newBook") Book book) {
		bookService.createBook(book);
		return "redirect:/";
	}
	

	@GetMapping("/book/{id}")
	public String book(
			@PathVariable Long id, 
			Model model, @ModelAttribute("newRating") Ratings rating) {
		model.addAttribute("book",bookService.getBookDetails(id));
		return "bookDetails.jsp";
	}
	
	@PostMapping("/book/addRating")
	public String addRating(@ModelAttribute("newRating") Ratings rating) {
		bookService.AddRating(rating);
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/borrow/{id}")
	public String borrow(
			@PathVariable Long id, HttpSession session) {
		User user= (User)session.getAttribute("loggedInUser");
		Book book=bookService.getBookNyId(id);
		bookService.borrowBook(book,user);
		return "redirect:/dashboard";
	}
	@GetMapping("/return/{id}")
	public String returnBook(
			@PathVariable Long id, HttpSession session) {
		User user= (User)session.getAttribute("loggedInUser");
		Book book=bookService.getBookNyId(id);
		bookService.returnBook(book,user);
		return "redirect:/dashboard";
	}

}
