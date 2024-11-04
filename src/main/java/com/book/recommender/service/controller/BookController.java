package com.book.recommender.service.controller;

import com.book.recommender.service.model.Book;
import com.book.recommender.service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // Endpoint to search books by title
    @GetMapping("/fetchByTitle")
    public List<Book> fetchByTitle(@RequestParam String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    // Endpoint to search books by type, additional filter (branch/genre), and rating
    @GetMapping("/fetchByTypeAndRating")
    public List<Book> fetchByTypeAndRating(
            @RequestParam String type,
            @RequestParam(required = false) String additional,
            @RequestParam double rating) {

        // Determine if the additional filter is branch or genre based on `type`
        String branch = "branch".equals(type) ? additional : null;
        String genre = "genre".equals(type) ? additional : null;

        return bookRepository.findByTypeAndFilters(branch, genre, rating);
    }
}
