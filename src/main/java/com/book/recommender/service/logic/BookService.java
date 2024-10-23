package com.book.recommender.service.logic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.book.recommender.service.model.Book;
import com.book.recommender.service.repository.BookRepository;

public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	public Optional<List<Book>> recommendBooks(String genre){
		return bookRepository.findByGenre(genre);
	}

}
