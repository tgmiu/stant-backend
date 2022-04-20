package com.webstore.stant.stantbackend.service;

import com.webstore.stant.stantbackend.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll(long productId);
     List<Review> findApprovedReviews(long productId, boolean isApproved);
     Review getById(long id);

    void save(Review review, long productId);
    void delete(long id);
}
