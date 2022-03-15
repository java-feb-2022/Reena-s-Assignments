package com.user.projects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.projects.models.Project;

import com.user.projects.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepo;

	// List all projects
	public List<Project> allProjects() {
		return projectRepo.findAll();
	}
	// Create new project
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}

	// Delete a Project
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}

	// Get One project details
	public Project getOneProject(Long id) {
		return projectRepo.findById(id).orElse(null);
	}

	// Update project
	public Project updateProject(Project project) {
		return projectRepo.save(project);

	}
}
