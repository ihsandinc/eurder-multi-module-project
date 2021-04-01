package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.customer.Customer;
import com.ihsan.eurder.domain.customer.CustomerRepository;
import com.ihsan.eurder.infrastructure.exceptions.CustomerNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {
    CustomerRepository customerRepository = new CustomerRepository();
    CustomerService customerService = new CustomerService(customerRepository);
    Customer customer;
    Customer customer2;

    @BeforeEach
    void init() {
        customer = new Customer("Ihsan","Dinc","ihsan@gmail.com","Kumtich","04444444");
        customer2 = new Customer("Inci","Dinc","inci@gmail.com","Kumtich","04444445");
    }

    @Test
    void givenACustomer_AddToRepository_ThenCustomerAccountIsAdded() {
        customerService.createCustomer(customer);
        assertNotNull(customerRepository.getCustomerById(customer.getCustomerId()));
    }

    @Test
    void givenCustomerId_IfItsNotFound_ThanThrowCustomerNotFoundException() {
        assertThrows(CustomerNotFoundException.class,() -> customerService.getCustomerById(UUID.fromString("123e4567-e89b-12d3-a456-556642449600")));
    }

    @Test
    void getAllCustomersFromRepository() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        customerList.add(customer2);

        customerRepository.addCustomer(customer);
        customerRepository.addCustomer(customer2);

        assertEquals(customerRepository.getCustomersAsList(),customerList);

    }


}