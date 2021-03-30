package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.Customer;
import com.ihsan.eurder.domain.CustomerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {
    CustomerRepository customerRepository = new CustomerRepository();
    CustomerService customerService = new CustomerService(customerRepository);

    @Test
    void givenACustomer_AddToRepository_ThenCustomerAccountIsAdded() {
        Customer customer = new Customer("Ihsan","Dinc","ihsan@gmail.com","Kumtich","04444444");
        customerService.createCustomer(customer);

        assertNotNull(customerRepository.getCustomersList().get(0));


    }
}