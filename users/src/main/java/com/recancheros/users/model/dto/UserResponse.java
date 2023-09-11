package com.recancheros.users.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponse {
    private String name;
    private String email;
    private String phoneNumber;
    private Set<String> roles;
}
