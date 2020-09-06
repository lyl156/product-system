package com.example.crud.Entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class IntegratedOrder {
    private Long orderId;
    private Customer customer;
    //make sure hashcode not change(only depend on id) => override hashcode() and equals()
    private HashMap<Product, Long> productAndAmount = new HashMap<>();
}
