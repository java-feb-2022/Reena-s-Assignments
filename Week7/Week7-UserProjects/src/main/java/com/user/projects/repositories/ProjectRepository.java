package com.user.projects.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.projects.models.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    
     List<Project> findAll();
//	List<Project> findAllByProjectName();
	List<Project> findByProjectName(String name);
	List<Project> findByProjectNameContains(String name);
	List<Project> findAllByOrderByProjectName();
	
	
//	JPQL
	@Query("SELECT p FROM Project p")
	List<Project> getAllProjects();
	
	@Query("SELECT p FROM Project p WHERE p.projectName LIKE %?1%")
	List<Project> getAllProjectsContains(String name);
	
	
	@Query("SELECT p FROM Project p ORDER BY p.likers.size")
	List<Project> getAllProjectsByLikesASC();
	
	@Query("SELECT p FROM Project p ORDER BY p.likers.size DESC")
	List<Project> getAllProjectsByLikesDESC();
	
	

//	Native Query
	@Query(value="SELECT * from projects;", nativeQuery=true)
	List<Project> getAllProjectsNative();

	
	
}