package com.eloarena.backend.common;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(
            MethodArgumentNotValidException exception
    ){
        FieldError fieldError = exception
                .getBindingResult()
                .getFieldErrors()
                .getFirst();

        String message = fieldError.getField() + ": " + fieldError.getDefaultMessage();

        ErrorResponse errorResponse = new ErrorResponse(
                400,
                "Bad Request",
                message
        );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResponse);

    }
}
