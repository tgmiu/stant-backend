package com.webstore.stant.stantbackend.service.impl;

import com.webstore.stant.stantbackend.entity.Product;
import com.webstore.stant.stantbackend.entity.Review;
import com.webstore.stant.stantbackend.repository.ProductRepository;
import com.webstore.stant.stantbackend.repository.ReviewRepository;
import com.webstore.stant.stantbackend.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }


    @Override
    public List<Review> findAll(long productId) {
        Product product = productRepository.findById(productId).get();
        return product.getReviews();
    }

    @Override
    public List<Review> findApprovedReviews(long productId, boolean isApproved) {
        Product product = productRepository.findById(productId).get();
        return product.getReviews().stream().filter(review -> review.isApproved()==isApproved).collect(Collectors.toList());
    }


    @Override
    public Review getById(long id) {
        return reviewRepository.getById(id);
    }

    @Override
    public void save(Review review, long productId) {
        Product product = productRepository.findById(productId).get();
        ArrayList<Review> reviews = new ArrayList<>();
        reviews.add(review);
        product.setReviews(reviews);

    }

    @Override
    public void delete(long id) {
        reviewRepository.delete(reviewRepository.getById(id));
    }
}
