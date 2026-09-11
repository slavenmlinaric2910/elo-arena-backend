package com.eloarena.backend.organization;

public class OrganizationCodeAlreadyExistsException extends RuntimeException{

    public OrganizationCodeAlreadyExistsException(String message){
        super(message);
    }
}
