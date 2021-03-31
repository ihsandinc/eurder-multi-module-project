package com.ihsan.eurder.api.customer;

import com.ihsan.eurder.domain.customer.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerDtoMapper {

    public Customer mapCreateCustomerDtoToCustomer(CreateCustomerDto createCustomerDto) {
        return new Customer(createCustomerDto.getFirstName(),
                createCustomerDto.getLastName(),
                createCustomerDto.getEmail(),
                createCustomerDto.getAdress(),
                createCustomerDto.getPhoneNumber());
    }

    public CreateCustomerDto mapCustomerToCreateCustomerDto(Customer customer) {
        return new CreateCustomerDto(customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAdress(),
                customer.getPhoneNumber());
    }

    public GetCustomerDto mapCustomerToGetCustomerDto(Customer customer) {
        return new GetCustomerDto(customer.getCustomerId(), customer.getFirstName(), customer.getLastName());
    }

    public List<GetCustomerDto> mapCustomerListToGetCustomerDtoList(List<Customer> customerList) {
        return customerList.stream().map(this::mapCustomerToGetCustomerDto).collect(Collectors.toList());
    }



}
