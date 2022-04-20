package com.webstore.stant.stantbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;


    private boolean isActive;
    //    @Enumerated(EnumType.STRING)
//    private Role role;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;
    @Embedded
    private ShippingAddress shippingAddress;


}
