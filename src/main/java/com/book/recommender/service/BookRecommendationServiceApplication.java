package com.book.recommender.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.book.recommender.service.logic.BookService;
import com.book.recommender.service.model.Book;
import com.book.recommender.service.model.Recommendation;
import com.book.recommender.service.model.User;
import com.book.recommender.service.repository.BookRepository;
import com.book.recommender.service.repository.RecommendationRepository;
import com.book.recommender.service.repository.UserRepository;

@SpringBootApplication
public class BookRecommendationServiceApplication implements CommandLineRunner{
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RecommendationRepository recommendationRepository;

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

        /*Book book2 = new Book();
        book2.setTitle("Clean Code");
        book2.setAuthor("Robert C. Martin");
        book2.setGenre("Programming");*/

       bookRepository.save(book1);
       //bookRepository.save(book2);

        // Print all books to verify
        System.out.println("Books in the database:");
        Optional<List<Book>> books = bookRepository.findByGenre("Programming");
        System.out.print(books);
        
   
        User user = new User();
        user.setFirstname("Kalyan");
        user.setLastname("Kanakam");
        user.setUsername("ka");
        user.setPassword("kalyan@123");
        user.setEmail("kalyan@gmail.com");
        user.setMobile("123456789");
        
        userRepository.save(user);
        
        //print
        List<User> users = userRepository.findAll();
        System.out.println(users);
        
        
        //create reviews
        Recommendation recommendation = new Recommendation();
        recommendation.setUser(user);
        recommendation.setBook(book1);
        recommendation.setRating(5L);
        recommendationRepository.save(recommendation);
        
        List<Recommendation> rec = recommendationRepository.findAll();
        System.out.println(rec);
    }

}
