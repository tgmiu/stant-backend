package com.webstore.stant.stantbackend.repository;

import com.webstore.stant.stantbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
