package com.eloarena.backend.organization;


import java.util.UUID;

public class OrganizationNotFoundException extends RuntimeException {

    public OrganizationNotFoundException(UUID id) {
        super("Organization with id: " + id + " not found.");
    }
}