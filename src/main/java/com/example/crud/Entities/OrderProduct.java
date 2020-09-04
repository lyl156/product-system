package com.example.crud.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn // foreign key
    private MyOrder myOrder;

    @ManyToOne
    @JoinColumn  // foreign key
    private Product product;

    private Long purchaseAmount;
}
