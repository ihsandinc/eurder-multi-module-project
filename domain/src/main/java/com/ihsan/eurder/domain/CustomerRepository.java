package com.ihsan.eurder.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private final List<Customer> customersList;

    public CustomerRepository() {
        this.customersList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customersList.add(customer);
    }

    public List<Customer> getCustomersList() {
        return customersList;
    }
}
