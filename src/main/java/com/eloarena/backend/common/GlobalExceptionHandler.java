package com.eloarena.backend.common;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.eloarena.backend.organization.OrganizationCodeAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrganizationCodeAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleOrganizationCodeAlreadyExists(
            OrganizationCodeAlreadyExistsException exception
    ){
        ErrorResponse errorResponse = new ErrorResponse(
                409,
                "Conflict",
                exception.getMessage()
        );

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(errorResponse);

    }
}
