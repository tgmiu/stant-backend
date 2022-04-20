package com.webstore.stant.stantbackend.dto;

import com.webstore.stant.stantbackend.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Order order;
    private String userEmail;
}
