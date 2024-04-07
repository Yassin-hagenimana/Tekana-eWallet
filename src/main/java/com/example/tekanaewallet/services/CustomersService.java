package com.example.tekanaewallet.services;

import com.example.tekanaewallet.models.Customer;
import com.example.tekanaewallet.models.dtos.CreateCustomerDTO;
import com.example.tekanaewallet.models.dtos.UpdateCustomerDTO;
import com.example.tekanaewallet.models.dtos.UpdateTransactionsDTO;

import java.util.List;
import java.util.UUID;

public interface CustomersService {
    List<Customer> getCustomers();

    Customer getCustomerById(UUID id);


    Customer createCustomer(CreateCustomerDTO dto);

    Customer updateCustomer(UUID id, UpdateCustomerDTO dto);

    Boolean deleteCustomer(UUID id);
}
