package com.ihsan.eurder.api.controllers;

import com.ihsan.eurder.api.CreateCustomerDto;
import com.ihsan.eurder.api.CustomerDtoMapper;
import com.ihsan.eurder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
   private final CustomerService customerService;
   private final CustomerDtoMapper customerDtoMapper;

   @Autowired
    public CustomerController(CustomerService customerService, CustomerDtoMapper customerDtoMapper) {
        this.customerService = customerService;
       this.customerDtoMapper = customerDtoMapper;
   }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomerAccount(@RequestBody CreateCustomerDto createCustomerDto) {
       customerService.createCustomer(customerDtoMapper.mapCreateCustomerDtoToCustomer(createCustomerDto));
    }



}
