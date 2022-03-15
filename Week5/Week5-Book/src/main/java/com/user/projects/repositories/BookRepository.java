package com.user.projects.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.projects.models.Book;
import com.user.projects.models.User;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    
	List<Book> findAll();
	List<Book> findAllByBorrower(User user);
	List<Book> findByBorrowerIsNull();
    
}