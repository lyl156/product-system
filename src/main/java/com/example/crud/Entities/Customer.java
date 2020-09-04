package com.example.crud.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
//mappedBy = {association-mapping attribute on the owning side}
    private List<MyOrder> myOrders = new ArrayList<>();

}
