package com.webstore.stant.stantbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double rating;
    private String comment;
    private boolean isApproved;
    private LocalDate createdAt;
    @OneToOne
    @JoinColumn
    private User user;


}
