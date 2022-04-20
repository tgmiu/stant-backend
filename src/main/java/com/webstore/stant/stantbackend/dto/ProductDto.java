package com.webstore.stant.stantbackend.dto;

import com.webstore.stant.stantbackend.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {
    List<Product> products;

}
