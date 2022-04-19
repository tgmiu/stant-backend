package com.webstore.stant.stantbackend.service;

import com.webstore.stant.stantbackend.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product getById(long id);

    void save(Product product);
    void delete(long id);
}
