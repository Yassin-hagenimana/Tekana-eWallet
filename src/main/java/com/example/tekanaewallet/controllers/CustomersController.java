package com.example.tekanaewallet.controllers;

import com.example.tekanaewallet.models.Customer;
import com.example.tekanaewallet.models.dtos.CreateCustomerDTO;
import com.example.tekanaewallet.models.dtos.UpdateCustomerDTO;
import com.example.tekanaewallet.services.CustomersService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
@Validated
public class CustomersController {
private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customersService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable UUID id) {
        return customersService.getCustomerById(id);
    }
    @PostMapping("/save")
    public Customer createCustomer(@RequestBody CreateCustomerDTO customer) {
        return customersService.createCustomer(customer);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable UUID id, @RequestBody UpdateCustomerDTO customer) {
        return customersService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCustomer(@PathVariable UUID id) {
        return customersService.deleteCustomer(id);
    }
}
