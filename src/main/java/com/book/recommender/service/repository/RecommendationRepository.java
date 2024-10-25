package com.book.recommender.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.recommender.service.model.Recommendation;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
	List<Recommendation> findByUserId(Long userId);
}
