package com.webstore.stant.stantbackend.v1.controller;

import com.webstore.stant.stantbackend.entity.Review;
import com.webstore.stant.stantbackend.entity.User;
import com.webstore.stant.stantbackend.service.ReviewService;
import com.webstore.stant.stantbackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ReviewController.BASE_URL)
@CrossOrigin
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
    final static String BASE_URL = "/api/v1/products/{id}/reviews";
    @GetMapping()
    public List<Review> getReviews(@PathVariable long id){
        return reviewService.findAll(id);
    }
    @GetMapping("/filter")
    public List<Review> getApprovedReviews(@RequestParam(required = false) boolean isApproved, @PathVariable long id){
        return reviewService.findApprovedReviews(id, isApproved);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Review review, @PathVariable long productId) {
        reviewService.save(review, productId);
    }

}
