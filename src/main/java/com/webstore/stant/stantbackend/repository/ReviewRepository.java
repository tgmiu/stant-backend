package com.webstore.stant.stantbackend.repository;

import com.webstore.stant.stantbackend.entity.Review;
import com.webstore.stant.stantbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
