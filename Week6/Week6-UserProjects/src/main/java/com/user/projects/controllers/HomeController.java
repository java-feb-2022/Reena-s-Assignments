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
import org.springframework.web.bind.annotation.PutMapping;

import com.user.projects.models.LoginUser;
import com.user.projects.models.Project;
import com.user.projects.models.User;
import com.user.projects.services.ProjectService;
import com.user.projects.services.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired 
	private HttpSession session;

	
	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User user, 
			@ModelAttribute("newLogin") LoginUser loginUser) {
		return "index.jsp";
	}

// ************Register a User***************
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("newUser") User user,
			BindingResult result
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
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

//	 **********************Project Routes************************* 
	@GetMapping("/dashboard")
	public String dashboard(Model projectModel) {
//		Check if user is in session
		if(session.getAttribute("loggedInUser")!=null) {
			User user=(User)session.getAttribute("loggedInUser");
			User userLoggedIn=userService.findById(user.getId());
			projectModel.addAttribute("projects", projectService.allProjects());
			projectModel.addAttribute("userLoggedIn",userLoggedIn);
			return "dashboard.jsp";
		}
		else {
			return "redirect:/";
		}
	}
//	Check if user is in session for all get routes
//	New Project
	@GetMapping("/new")
	public String newProject(@ModelAttribute("newProject") Project project) {
	  if(session.getAttribute("loggedInUser")!=null) {
			return "new.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
//	Create Project
	@PostMapping("/projects/create")
	public String CreateProject(@Valid @ModelAttribute("newProject") Project project, BindingResult results) {
		if(results.hasErrors()) {
			return "new.jsp";
		}
		else {
			projectService.createProject(project);
			return "redirect:/dashboard";
		}
		
	}
	
//	Get One project details - Allow edit/delete
	@GetMapping("/projects/projectDetails/{id}")
	public String projectDetils(@PathVariable Long id, Model projectModel, HttpSession session) {
		if(session.getAttribute("loggedInUser")!=null) {
			Project myProject=projectService.getOneProject(id);
			projectModel.addAttribute("project",myProject);
			return "projectDetails.jsp";
		}
		else {
			return "redirect:/";
		}
		
		
	}
	
//	Delete project 
	@GetMapping("/delete/{id}")
	public String deleteProject(@PathVariable Long id) {
		if(session.getAttribute("loggedInUser")!=null) {
			projectService.deleteProject(id);
			return "redirect:/dashboard";
		}
		else {
			return "redirect:/";
		}
		
	}

	
//	Edit Page 

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, @ModelAttribute("editedProject") Project project, Model model,
			HttpSession session) {
		Project editProject = projectService.getOneProject(id);
		model.addAttribute("editProject", editProject);
		return "edit.jsp";
	}

	// Update project
	@PutMapping("/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("editedProject") Project project,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			projectService.updateProject(project);
			return "redirect:/dashboard";

		}
	}

	
//	Like Project 
	@GetMapping("/project/{id}/like")
	public String likeProject(@PathVariable Long id) {
		Project project=projectService.getOneProject(id);
		User user=(User)session.getAttribute("loggedInUser");
		User UserWhoIsLiking=userService.findById(user.getId());
		projectService.likeProject(project, UserWhoIsLiking);
		return "redirect:/dashboard";
	}
	
//	Unlike
	@GetMapping("/project/{id}/unLike")
	public String UnlikeProject(@PathVariable Long id) {
		Project project=projectService.getOneProject(id);
		User user=(User)session.getAttribute("loggedInUser");
		User UserWhoIsUnLiking=userService.findById(user.getId());
		projectService.unLikeProject(project, UserWhoIsUnLiking);
		return "redirect:/dashboard";
	}

	

}
