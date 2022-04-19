package com.webstore.stant.stantbackend.repository;

import com.webstore.stant.stantbackend.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
