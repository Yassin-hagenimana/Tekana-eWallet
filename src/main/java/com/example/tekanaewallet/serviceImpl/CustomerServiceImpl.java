package com.example.tekanaewallet.serviceImpl;

import com.example.tekanaewallet.exceptions.CustomerNotFoundExceptions;
import com.example.tekanaewallet.models.Customer;
import com.example.tekanaewallet.models.dtos.CreateCustomerDTO;
import com.example.tekanaewallet.models.dtos.UpdateCustomerDTO;
import com.example.tekanaewallet.repositories.CustomersRepository;
import com.example.tekanaewallet.services.CustomersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomersService {

    private final CustomersRepository customersRepository;

    public CustomerServiceImpl(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        return customersRepository.findAll();
    }

    @Override
    public Customer getCustomerById(UUID id) {
        Optional<Customer> customer = customersRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundExceptions("Customer not found");
        }else {
            return customer.get();
        }
    }

    @Override
    public Customer createCustomer(CreateCustomerDTO dto) {
        Customer customer = new Customer();
        customer.setNames(dto.getNames());
        customer.setNationalId(dto.getNationalId());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setCountry(dto.getCountry());
        return customersRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(UUID id, UpdateCustomerDTO dto) {
        Optional<Customer> foundCustomer = customersRepository.findById(id);
        if (foundCustomer.isEmpty()) {
            throw new CustomerNotFoundExceptions("Customer not found");
        }else {
            Customer updatedCustomer = foundCustomer.get();
                updatedCustomer.setNames(dto.getNames());
                updatedCustomer.setNationalId(dto.getNationalId());
                updatedCustomer.setEmail(dto.getEmail());
                updatedCustomer.setPhoneNumber(dto.getPhoneNumber());
                updatedCustomer.setCountry(dto.getCountry());

                return customersRepository.save(updatedCustomer);
        }
    }

    @Override
    public Boolean deleteCustomer(UUID id) {
    Optional<Customer> customer = customersRepository.findById(id);
    if (customer.isEmpty()) {
        throw new CustomerNotFoundExceptions("Customer not found");
    }else {
        customersRepository.deleteById(id);
        return true;
    }
    }
}
