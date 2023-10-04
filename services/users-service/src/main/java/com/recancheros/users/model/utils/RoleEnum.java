package com.recancheros.users.model.utils;

public enum RoleEnum {
    USER("USER"),
    ADMIN("ADMIN");

    private final String message;

    RoleEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
