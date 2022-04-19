package com.webstore.stant.stantbackend.service.impl;

import com.webstore.stant.stantbackend.entity.Product;
import com.webstore.stant.stantbackend.repository.ProductRepository;
import com.webstore.stant.stantbackend.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
//        ArrayList<Product> products = new ArrayList<>();
//        products.add(new Product(1, "Airpods Wireless Bluetooth Headphones",
//                "/images/airpods.jpg",
//                "Bluetooth technology lets you connect it with compatible devices wirelessly High-quality AAC audio offers immersive listening experience Built-in microphone allows you to take calls while working", "Apple",
//                "Electronics", 89.99, 3, 4.5, 4));
//        return products;
        return productRepository.findAll();
    }

    @Override
    public Product getById(long id) {
        return productRepository.getById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(long id) {
        Product product = productRepository.getById(id);
        productRepository.delete(product);
    }
}
