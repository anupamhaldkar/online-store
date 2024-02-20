package com.spring.onlinestore.controller;

import com.spring.onlinestore.model.Customer;
import com.spring.onlinestore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }
}
