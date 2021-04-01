package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.customer.Customer;
import com.ihsan.eurder.domain.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }


    public List<Customer> getCustomers() {
       return customerRepository.getCustomersAsList();
    }

    public Customer getCustomerById(UUID id) {
        return customerRepository.getCustomerById(id);
    }
}
