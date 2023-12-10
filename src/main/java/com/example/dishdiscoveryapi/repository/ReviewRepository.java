package com.example.dishdiscoveryapi.repository;

import com.example.dishdiscoveryapi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
