package com.example.dishdiscoveryapi.service;

import com.example.dishdiscoveryapi.model.Review;
import com.example.dishdiscoveryapi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public void addNewReview(Review review) {
        if (!reviewRepository.existsById(review.getId())) {
            reviewRepository.save(review);
        } else {
            throw new IllegalStateException("Review Already Exists");
        }
    }

    public void deleteReview(Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
        } else {
            throw new IllegalStateException("Review with id: " + id + " does not exits");
        }
    }

    public void updateReview(Long id, Review review) {
        Review reviewToUpdate = reviewRepository.findById(id)
                .orElseThrow(
                        () -> {
                            new IllegalStateException("Review with id: " + id + " does not exits");
                            return null;
                        }
                );
        reviewToUpdate.setTitle(review.getTitle());
        reviewToUpdate.setRating(review.getRating());
        reviewToUpdate.setComment(review.getComment());
    }
}
