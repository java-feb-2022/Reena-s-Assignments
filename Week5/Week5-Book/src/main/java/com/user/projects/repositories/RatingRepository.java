package com.user.projects.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.projects.models.Ratings;

@Repository
public interface RatingRepository extends CrudRepository<Ratings, Long> {
    
    
}