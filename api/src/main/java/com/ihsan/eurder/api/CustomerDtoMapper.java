package com.ihsan.eurder.api;

import com.ihsan.eurder.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoMapper {

    public Customer mapCreateCustomerDtoToCustomer(CreateCustomerDto createCustomerDto) {
        return new Customer(createCustomerDto.getFirstName(),
                createCustomerDto.getLastName(),
                createCustomerDto.getEmail(),
                createCustomerDto.getAdress(),
                createCustomerDto.getPhoneNumber());
    }


}
