package com.webstore.stant.stantbackend.service;

import com.webstore.stant.stantbackend.entity.Order;
import com.webstore.stant.stantbackend.entity.Product;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order getById(long id);

    void save(Order order);
    void delete(long id);
}
