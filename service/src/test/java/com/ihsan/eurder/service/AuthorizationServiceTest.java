package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.admin.AdminRepository;
import com.ihsan.eurder.domain.customer.Customer;
import com.ihsan.eurder.domain.customer.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationServiceTest {
    private final AdminRepository adminRepository = new AdminRepository();
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final AuthorizationService authorizationService = new AuthorizationService(adminRepository,customerRepository);

    @Test
    void givingNullId_whenValidatingAdmin_thenThrowIllegalAccessException() {
        Executable executable = () -> authorizationService.throwExceptionIfNotAdmin(null);
        assertThrows(IllegalAccessException.class, executable);
    }

    @Test
    void givingWrongSizedId_whenValidatingAdmin_thenThrowIllegalAccessException() {
        Executable executable = () -> authorizationService.throwExceptionIfNotAdmin("ihsan");
        assertThrows(IllegalAccessException.class, executable);
    }

    @Test
    void givingWrongId_whenValidatingAdmin_thenThrowIllegalAccessException() {
        Executable executable = () -> authorizationService.throwExceptionIfNotAdmin("123e4567-e89b-12d3-a456-556642449600");
        assertThrows(IllegalAccessException.class, executable);
    }

    @Test
    void givingCorrectId_whenValidatingAdmin_thenLogIn() {
        Executable executable = () -> authorizationService.throwExceptionIfNotAdmin("123e4567-e89b-12d3-a456-556642440000");
        assertDoesNotThrow(executable);
    }

    @Test
    void givingWrongId_whenValidatingCustomer_thenThrowIllegalAccessException() {
        Executable executable = () -> authorizationService.throwExceptionIfNotCustomer("123e4567-e89b-12d3-a456-556642449600");
        assertThrows(IllegalAccessException.class, executable);
    }

    @Test
    void givingCorrectMemberId_whenValidatingLoggedIn_thenLogIn() {
        Customer customer = new Customer("Ihsan","Dinc","ihsan@gmail.com","Kumtich","0444444");
        customerRepository.addCustomer(customer);
        Executable executable = () -> authorizationService.throwExceptionIfNotCustomer(customer.getCustomerId().toString());
        assertDoesNotThrow(executable);
    }



}