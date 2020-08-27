package com.example.crud.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    //generationType.identity vs auto
    //https://stackoverflow.com/questions/33096466/generationtype-auto-vs-generationtype-identity-in-hibernate
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String name;
    private Long price;
}
