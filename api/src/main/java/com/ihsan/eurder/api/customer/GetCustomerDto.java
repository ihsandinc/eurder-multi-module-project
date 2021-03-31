package com.ihsan.eurder.api.customer;

import java.util.UUID;

public class GetCustomerDto {
    private final UUID customerId;
    private final String firstName;
    private final String lastName;

    public GetCustomerDto(UUID customerId, String firstName, String lastName) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
