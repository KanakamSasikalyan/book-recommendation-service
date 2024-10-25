package com.book.recommender.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.recommender.service.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findUserByUserName(String username);
}
