package com.eloarena.backend.common;

public record ErrorResponse(
        int status,
        String error,
        String message
) {}