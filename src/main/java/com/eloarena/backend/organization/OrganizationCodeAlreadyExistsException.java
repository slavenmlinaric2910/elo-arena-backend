package com.eloarena.backend.organization;

public class OrganizationCodeAlreadyExistsException extends RuntimeException{

    public OrganizationCodeAlreadyExistsException() {
        super("Organization code already exists");
    }
}
