package com.webstore.stant.stantbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class ShippingAddress {
    private String address;
    private String city;
    private String postalCode;
    private String country;
}