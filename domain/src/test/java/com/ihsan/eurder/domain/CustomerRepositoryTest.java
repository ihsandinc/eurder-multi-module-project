package com.ihsan.eurder.domain;

import com.ihsan.eurder.domain.customer.Customer;
import com.ihsan.eurder.domain.customer.CustomerRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {
    private final CustomerRepository customerRepository = new CustomerRepository();

    @Test
    void addCustomerAccount() {
        Customer customer = new Customer( "Ihsan","Dinc","ihsan@gmail.com","Kumtich","04444444");
       // Customer customer1 = new Customer( "Ihsan","Dinc","ihsan@gmail.com","Kumtich","04444444");
        customerRepository.addCustomer(customer);


        assertEquals(customer,customerRepository.getCustomerMap().get(customer.getCustomerId()));



    }
}