package com.example.crud.Services.Customer;

import com.example.crud.Entities.Customer;
import com.example.crud.Entities.Product;

public interface CustomerService {
    Iterable<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);
}
