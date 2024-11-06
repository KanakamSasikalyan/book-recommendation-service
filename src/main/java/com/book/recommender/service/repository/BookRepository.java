package com.book.recommender.service.repository;
import com.book.recommender.service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    Book findByTitleAndAuthor(String title, String author);
    // JpaSpecificationExecutor provides Specification-based methods for dynamic querying
}
