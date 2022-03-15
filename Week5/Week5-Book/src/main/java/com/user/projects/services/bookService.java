package com.user.projects.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.projects.models.Book;
import com.user.projects.models.Ratings;
import com.user.projects.models.User;
import com.user.projects.repositories.BookRepository;
import com.user.projects.repositories.RatingRepository;
import com.user.projects.repositories.UserRepository;

@Service
public class bookService {
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private UserRepository UserRepo;
	
	@Autowired
	private RatingRepository ratingRepo;
	
	
//	All Users
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	public List<Book> getBooksByBorrower(User user){
		return bookRepo.findAllByBorrower(user);
	}
	public List<Book> getAvilable(User user){
		return bookRepo.findByBorrowerIsNull();
	}
//	Create Book
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
//	Get Book by id
	
//	Get Bookdeatils
	public Book getBookDetails(Long id) {
		return bookRepo.findById(id).orElse(null);
	}
//  Update Book
//	Add Rating to Book 
	public void AddRating(Ratings rating) {
		ratingRepo.save(rating);
	}
	
//	Delete Book
	
//	Add borrower of the book 
	public void borrowBook(Book book, User user) {
//		System.out.println(user.getUserName());
//		List<Book> borrowedBooks = user.getBorrowedbooks();
//		borrowedBooks.add(book);
//		System.out.println("***********************************");
//		UserRepo.save(user);
		book.setBorrower(user);
		bookRepo.save(book);
		
		
	}
	
	public void returnBook(Book book, User user) {
		book.setBorrower(null);
		bookRepo.save(book);
	}
	public Book getBookNyId(Long id) {
		// TODO Auto-generated method stub
		return bookRepo.findById(id).orElse(null);
	}
	
	

}
