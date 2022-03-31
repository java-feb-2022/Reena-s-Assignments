package com.user.projects.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name="projects")
public class Project {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty(message="Project Name is required!")
    @Size(min = 2, max = 200)
	private String projectName;
	
	@NotEmpty(message="Project description is required!")
    @Size(min = 2, max = 1000)
	private String description;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "likes", 
        joinColumns = @JoinColumn(name = "project_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> likers;
	
//	Rating relationship
	  @OneToMany(mappedBy="ratedProject", fetch = FetchType.LAZY)
	  private List<Rating> ratings;
	
	  
//	  Image attribute
	  private String imgUrl;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getLikers() {
		return likers;
	}

	public void setLikers(List<User> likers) {
		this.likers = likers;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	
	public float getAvgRating() {
		float sum=0;
		for(Rating rating:ratings) {
			sum+=rating.getRating();
		}
		if(sum!=0) {
			sum=sum/ratings.size();
			return sum;
		}
		else {
			return 0.0f;
		}
	}
	
	
	public boolean isNotRatedByUser(Long user_id) {
		for (Rating rating : ratings) {
			if(rating.getRatedBy().getId()==user_id) {
				return false;
			}
			
		}
		return true;
		
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	

	



	
	
}