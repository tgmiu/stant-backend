package com.webstore.stant.stantbackend.service.impl;

import com.webstore.stant.stantbackend.dto.OrderDto;
import com.webstore.stant.stantbackend.entity.Item;
import com.webstore.stant.stantbackend.entity.Order;
import com.webstore.stant.stantbackend.entity.User;
import com.webstore.stant.stantbackend.repository.OrderRepository;
import com.webstore.stant.stantbackend.repository.UserRepository;
import com.webstore.stant.stantbackend.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(long id) {
        return orderRepository.getById(id);
    }

    @Override
    public void save(OrderDto orderDto) {
        String userEmail = orderDto.getUserEmail();

        User user = userRepository.findByEmail(userEmail);
        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(orderDto.getOrder().getCreatedAt());
        List<Item> orderItems = orderDto.getOrder().getOrderItems();
        order.setOrderItems(orderItems);
        order.setDelivered(false);
        order.setPaymentMethod(orderDto.getOrder().getPaymentMethod());

        order.setItemsPrice(orderDto.getOrder().getItemsPrice());
        order.setTaxPrice(orderDto.getOrder().getTaxPrice());
        order.setShippingPrice(orderDto.getOrder().getShippingPrice());
        order.setTotalPrice(orderDto.getOrder().getTotalPrice());
        order.setShippingAddress(orderDto.getOrder().getShippingAddress());
        orderRepository.save(order);
    }

    @Override
    public void delete(long id) {
        orderRepository.delete(orderRepository.getById(id));
    }
}
