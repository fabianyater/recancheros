package com.recancheros.fieldsservice.exceptions.config;

public enum ExceptionResponse {
    USER_NOT_FOUND("User not found");
    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
