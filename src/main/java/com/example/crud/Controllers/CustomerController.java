package com.example.crud.Controllers;

import com.example.crud.Entities.Customer;
import com.example.crud.Entities.Product;
import com.example.crud.Services.Customer.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("customer/{Id}")
    public String showCustomerById(@PathVariable Long Id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(Id));
        return "customer/showCustomerById";
    }

    @RequestMapping(value = "customers", method = RequestMethod.GET)
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer/customers";
    }

    @RequestMapping("customer/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customerForm";
    }

    @RequestMapping(value = "customer", method = RequestMethod.POST)
    public String saveCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/customer/" + customer.getId();
    }

    @RequestMapping("customer/edit/{Id}")
    public String edit(@PathVariable Long Id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(Id));
        return "customer/customerForm";
    }

    @RequestMapping("customer/delete/{Id}")
    public String delete(@PathVariable Long Id) {
        Customer customer = customerService.getCustomerById(Id);

        customerService.deleteCustomer(Id);
        return "redirect:/";
    }
}
