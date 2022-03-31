package com.user.projects.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="ratings")
public class Rating {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Range(min=0, max=5, message = "min:0/max:5")
    private int rating;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User ratedBy;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="project_id")
    private Project ratedProject;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public User getRatedBy() {
		return ratedBy;
	}

	public void setRatedBy(User ratedBy) {
		this.ratedBy = ratedBy;
	}

	public Project getRatedProject() {
		return ratedProject;
	}

	public void setRatedProject(Project ratedProject) {
		this.ratedProject = ratedProject;
	}
   
	
}