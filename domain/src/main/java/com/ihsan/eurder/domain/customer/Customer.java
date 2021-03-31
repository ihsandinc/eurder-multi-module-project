package com.ihsan.eurder.domain.customer;

import com.ihsan.eurder.infrastructure.ValidationUtil;

import java.util.Objects;
import java.util.UUID;

public class Customer {
    private final UUID customerId;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String adress;
    private final String phoneNumber;


    public Customer(String firstName, String lastName, String email, String adress, String phoneNumber) {
        this.customerId = UUID.randomUUID();
        ValidationUtil.throwExceptionIfNull(adress,"Adress");
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
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

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email) && Objects.equals(phoneNumber, customer.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phoneNumber);
    }
}
