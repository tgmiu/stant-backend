package com.webstore.stant.stantbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String paymentMethod;
    private boolean isDelivered;
    private boolean isPaid;
    private LocalDate createdAt;
    @ManyToOne
    @JoinColumn
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Item> orderItems;
    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private PaymentResult paymentResult;
    private double taxPrice;
    private double shippingPrice;
    private double totalPrice;
}
