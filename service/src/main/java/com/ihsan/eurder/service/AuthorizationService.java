package com.ihsan.eurder.service;

import com.ihsan.eurder.domain.AdminRepository;
import com.ihsan.eurder.infrastructure.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorizationService {
    private final AdminRepository adminRepository;

    @Autowired
    public AuthorizationService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    public void throwExceptionIfNotAdmin(String userId) throws IllegalAccessException {
        if (isInvalidUUID(userId) || !isAdmin(userId)) {
            throw new IllegalAccessException("Only admins can access this page");
        }
    }

    private boolean isInvalidUUID(String userId) {
        return ValidationUtil.isNullObject(userId) || !ValidationUtil.isValidUUIDLength(userId);
    }

    private boolean isAdmin(String userId) {
        return adminRepository.isAdmin(UUID.fromString(userId));
    }


}
