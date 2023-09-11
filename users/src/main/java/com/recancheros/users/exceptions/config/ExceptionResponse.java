package com.recancheros.users.exceptions.config;

public enum ExceptionResponse {
    USER_NOT_FOUND("User not found"),
    USER_ALREADY_EXISTS("User already exists");
    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
