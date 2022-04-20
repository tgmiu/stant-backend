package com.webstore.stant.stantbackend.v1.controller;

import com.webstore.stant.stantbackend.dto.OrderDto;
import com.webstore.stant.stantbackend.entity.Order;
import com.webstore.stant.stantbackend.entity.Product;
import com.webstore.stant.stantbackend.service.OrderService;
import com.webstore.stant.stantbackend.service.ProductService;
import com.webstore.stant.stantbackend.service.impl.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(OrderController.BASE_URL)
@CrossOrigin
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    final static String BASE_URL = "/api/v1/orders";
    @GetMapping()
    public List<Order> getOrders(){
        return orderService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order getById(@PathVariable long id) {
        return orderService.getById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void save(@RequestBody OrderDto order) {
        orderService.save(order);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        orderService.delete(id);
    }

}
