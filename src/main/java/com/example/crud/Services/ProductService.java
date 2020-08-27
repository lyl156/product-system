package com.example.crud.Services;

import com.example.crud.Entities.Product;

public interface ProductService {
    Iterable<Product> getAllProducts();

    Product getProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);
}
