package com.recancheros.sportcenters.exceptions.config;

public enum ExceptionResponse {
    USER_NOT_FOUND("User not found"),
    USER_ALREADY_EXISTS("User already exists"),
    AUTHENTICATION_FAILED("Authentication failed");
    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
