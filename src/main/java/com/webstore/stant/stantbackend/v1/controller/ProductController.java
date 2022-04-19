package com.webstore.stant.stantbackend.v1.controller;

import com.webstore.stant.stantbackend.entity.Product;
import com.webstore.stant.stantbackend.service.ProductService;
import com.webstore.stant.stantbackend.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ProductController.BASE_URL)
@CrossOrigin(origins = {"http://localhost:3000"})
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    final static String BASE_URL = "/api/v1/products";
    @GetMapping()
    public List<Product> getProducts(){
        return productService.findAll();
    }

}
