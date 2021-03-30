package com.ihsan.eurder.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class AdminRepository {
    private final Map<UUID,Admin> adminMap;


    public AdminRepository() {
        adminMap = new HashMap<>();
        Admin rootAdmin = new Admin(UUID.fromString("123e4567-e89b-12d3-a456-556642440000"),"Root", "Root", "root@root.com");
        adminMap.put(rootAdmin.getId(),rootAdmin);
    }

    public boolean isAdmin(UUID id) {
        return adminMap.get(id) != null;
    }

}
