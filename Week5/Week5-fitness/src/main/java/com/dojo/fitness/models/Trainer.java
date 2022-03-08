package com.dojo.fitness.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="trainers")
public class Trainer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	
	private String name;
		
	private String email;
	
	//Define relationship	
	@OneToMany(mappedBy ="trainer" ,fetch=FetchType.LAZY)
	private List<FitnessClass> fitnessClasses;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<FitnessClass> getFitnessClasses() {
		return fitnessClasses;
	}

	public void setFitnessClasses(List<FitnessClass> fitnessClasses) {
		this.fitnessClasses = fitnessClasses;
	}
	
	
	 
	
}
