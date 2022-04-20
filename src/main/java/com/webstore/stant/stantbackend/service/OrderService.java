package com.webstore.stant.stantbackend.service;

import com.webstore.stant.stantbackend.dto.OrderDto;
import com.webstore.stant.stantbackend.entity.Order;
import com.webstore.stant.stantbackend.entity.Product;

import java.util.List;

public interface OrderService {
    List<Order> findAll();

    Order getById(long id);

    void save(OrderDto order);
    void delete(long id);
}
