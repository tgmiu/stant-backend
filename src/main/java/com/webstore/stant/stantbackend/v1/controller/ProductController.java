package com.webstore.stant.stantbackend.v1.controller;

import com.webstore.stant.stantbackend.dto.ProductDto;
import com.webstore.stant.stantbackend.entity.Product;
import com.webstore.stant.stantbackend.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(ProductController.BASE_URL)
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    final static String BASE_URL = "/api/v1/products";

    @GetMapping()
    public ProductDto getProducts() {
        ProductDto productDto = new ProductDto();
        productDto.setProducts(productService.findAll());
        return productDto;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product getById(@PathVariable long id) {
        Product byId = productService.getById(id);
        ProductDto productDto = new ProductDto();
        ArrayList<Product> objects = new ArrayList<>();
        objects.add(byId);
        productDto.setProducts(objects);
        System.out.println(byId);
        return byId;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        productService.delete(id);
    }


}
