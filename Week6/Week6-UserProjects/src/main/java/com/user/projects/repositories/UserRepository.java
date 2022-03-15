package com.user.projects.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.projects.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
	User findByEmail(String email);
    
}