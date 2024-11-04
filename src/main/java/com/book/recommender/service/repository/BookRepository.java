package com.book.recommender.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.recommender.service.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitle(String title);

	List<Book> findByTitleContainingIgnoreCase(String title);

	@Query("SELECT b FROM Book b WHERE ((:branch IS NULL OR b.branch = :branch) OR (:genre IS NULL OR b.genre = :genre)) " +
			"AND b.rating >= :rating")
	List<Book> findByTypeAndFilters(@Param("branch") String branch,
									@Param("genre") String genre,
									@Param("rating") double rating);
}
