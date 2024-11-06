package com.book.recommender.service.controller;

import com.book.recommender.service.dto.RatingRequest;
import com.book.recommender.service.logic.BookService;
import com.book.recommender.service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("api/books")
    public List<Book> getBooks(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String branch,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer rating) {
        return bookService.findBooks(search, branch, genre, rating);
    }

    @PostMapping("api/updateRating")
    public String updateRating(@RequestBody RatingRequest ratingRequest) {
        try {
            bookService.updateRatingAndFeedback(
                    ratingRequest.getTitle(),
                    ratingRequest.getAuthor(),
                    ratingRequest.getRating(),
                    ratingRequest.getDescription()
            );
            return "Rating and feedback updated successfully!";
        } catch (Exception e) {
            return "Failed to update rating and feedback!";
        }
    }
}
