package com.ihsan.eurder.api.controllers;

import com.ihsan.eurder.api.customer.CreateCustomerDto;
import com.ihsan.eurder.api.customer.CustomerDtoMapper;
import com.ihsan.eurder.api.customer.GetCustomerDto;
import com.ihsan.eurder.api.item.CreateItemDto;
import com.ihsan.eurder.service.AuthorizationService;
import com.ihsan.eurder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
   private final CustomerService customerService;
   private final CustomerDtoMapper customerDtoMapper;
   private final AuthorizationService authorizationService;

   @Autowired
    public CustomerController(CustomerService customerService, CustomerDtoMapper customerDtoMapper, AuthorizationService authorizationService) {
        this.customerService = customerService;
       this.customerDtoMapper = customerDtoMapper;
       this.authorizationService = authorizationService;
   }

   @GetMapping(path = "/{id}", produces = "application/json")
   @ResponseStatus(HttpStatus.OK)
   public GetCustomerDto getCustomer(@PathVariable UUID id,@RequestHeader(value = "Authorization", required = false) String adminId) throws IllegalAccessException {
       authorizationService.throwExceptionIfNotAdmin(adminId);
       return customerDtoMapper.mapCustomerToGetCustomerDto(customerService.getCustomerById(id));
   }


    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<GetCustomerDto> getCustomers(@RequestHeader(value = "Authorization", required = false) String adminId) throws IllegalAccessException {
        authorizationService.throwExceptionIfNotAdmin(adminId);
        return customerDtoMapper.mapCustomerListToGetCustomerDtoList(customerService.getCustomers());
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomerAccount(@RequestBody CreateCustomerDto createCustomerDto) {
       customerService.createCustomer(customerDtoMapper.mapCreateCustomerDtoToCustomer(createCustomerDto));
    }



}
