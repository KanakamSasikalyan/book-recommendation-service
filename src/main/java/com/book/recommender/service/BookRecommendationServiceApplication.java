package com.book.recommender.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.book.recommender.service.logic.BookService;
import com.book.recommender.service.model.Book;
import com.book.recommender.service.repository.BookRepository;

@SpringBootApplication
public class BookRecommendationServiceApplication implements CommandLineRunner{
	
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookRecommendationServiceApplication.class, args);
	}
	
	@Override
    public void run(String... args) throws Exception {
        // Create sample books
        Book book1 = new Book();
        book1.setTitle("Effective Java");
        book1.setAuthor("Joshua Bloch");
        book1.setGenre("Programming");

        Book book2 = new Book();
        book2.setTitle("Clean Code");
        book2.setAuthor("Robert C. Martin");
        book2.setGenre("Programming");

       bookRepository.save(book1);
       bookRepository.save(book2);

        // Print all books to verify
        System.out.println("Books in the database:");
        Optional<List<Book>> books = bookRepository.findByGenre("Programming");
        System.out.print(books);
    }

}
