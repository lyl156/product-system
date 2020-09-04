package com.example.crud.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class MyOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId;

    //Many to one, foreign key
    @ManyToOne
    @JoinColumn
//    private Long customerId;
//    generate role : entity_name + pk(Customer_id)
    private Customer customer;

    //delete Order then delete Order_product
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "myOrder")
    private List<OrderProduct> orderProducts = new ArrayList<>();

}
