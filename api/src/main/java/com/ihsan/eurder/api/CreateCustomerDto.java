package com.ihsan.eurder.api;

public class CreateCustomerDto {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String adress;
    private final String phoneNumber;


    public CreateCustomerDto(String firstName, String lastName, String email, String adress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
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
}
