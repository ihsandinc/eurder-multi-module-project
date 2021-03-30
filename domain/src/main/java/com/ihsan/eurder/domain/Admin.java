package com.ihsan.eurder.domain;

import java.util.UUID;

public class Admin {
    private final UUID id;
    private final String lastName;
    private final String firstName;
    private final String email;

    public Admin(String lastName, String firstName, String email) {
        this.id = UUID.randomUUID();
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public Admin(UUID id, String lastName, String firstName, String email) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }
}
