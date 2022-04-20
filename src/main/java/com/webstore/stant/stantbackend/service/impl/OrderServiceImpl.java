package com.webstore.stant.stantbackend.service.impl;

import com.webstore.stant.stantbackend.entity.Order;
import com.webstore.stant.stantbackend.repository.OrderRepository;
import com.webstore.stant.stantbackend.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(long id) {
        return orderRepository.getById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
   @Override
    public void delete(long id) {
        orderRepository.delete(orderRepository.getById(id));
    }
}
