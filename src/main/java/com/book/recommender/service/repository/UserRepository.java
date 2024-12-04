package com.book.recommender.service.repository;

import com.book.recommender.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findById(Long Id);
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
}
