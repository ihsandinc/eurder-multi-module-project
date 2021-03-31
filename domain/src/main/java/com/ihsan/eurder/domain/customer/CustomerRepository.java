package com.ihsan.eurder.domain.customer;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {
    private final Map<UUID,Customer> customerMap;

    public CustomerRepository() {
        this.customerMap = new HashMap<>();
    }

    public void addCustomer(Customer customer) {
        customerMap.put(customer.getCustomerId(),customer);
    }

    public Map<UUID,Customer> getCustomerMap() {
        return customerMap;
    }


    public boolean isCustomer(UUID id) {
        return customerMap.get(id) != null;
    }

    public List<Customer> getCustomersAsList() {
        return new ArrayList<>(customerMap.values());
    }
}
