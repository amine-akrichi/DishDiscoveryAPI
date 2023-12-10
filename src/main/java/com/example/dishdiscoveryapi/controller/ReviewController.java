package com.example.dishdiscoveryapi.controller;

import com.example.dishdiscoveryapi.model.Review;
import com.example.dishdiscoveryapi.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public void getReviews(){
        reviewService.getReviews();
    }

    @PostMapping
    public void addNewReview(@RequestBody Review review){
        reviewService.addNewReview(review);
    }

    @DeleteMapping(path = "{reviewId}")
    public void deleteReview(@PathVariable("reviewId") Long id){
        reviewService.deleteReview(id);
    }

    @PutMapping(path = "{reviewId}")
    public void updateReview(@PathVariable Long reviewId , @RequestBody Review review){
        reviewService.updateReview(reviewId,review);
    }
}
