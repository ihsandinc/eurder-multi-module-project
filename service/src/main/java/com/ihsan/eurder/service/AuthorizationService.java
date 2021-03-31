package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.admin.AdminRepository;
import com.ihsan.eurder.domain.customer.CustomerRepository;
import com.ihsan.eurder.infrastructure.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorizationService {
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public AuthorizationService(AdminRepository adminRepository, CustomerRepository customerRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
    }


    public void throwExceptionIfNotAdmin(String userId) throws IllegalAccessException {
        if (isInvalidUUID(userId) || !isAdmin(userId)) {
            throw new IllegalAccessException("Only admins can access this page");
        }
    }

    public void throwExceptionIfNotCustomer(String userId) throws IllegalAccessException {
        if (isInvalidUUID(userId) || !isCustomer(userId)) {
            throw new IllegalAccessException("Only customers can access this page");
        }
    }

    private boolean isInvalidUUID(String userId) {
        return ValidationUtil.isNullObject(userId) || !ValidationUtil.isValidUUIDLength(userId);
    }

    private boolean isAdmin(String userId) {
        return adminRepository.isAdmin(UUID.fromString(userId));
    }

    private boolean isCustomer(String userId) {
        return customerRepository.isCustomer(UUID.fromString(userId));
    }


}
