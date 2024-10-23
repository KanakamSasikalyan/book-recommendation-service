package com.book.recommender.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.recommender.service.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	Optional<List<Book>> findByGenre(String genre);
}
