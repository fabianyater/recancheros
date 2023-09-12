package com.recancheros.users.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String fullName;
    private String username;
    private String email;
    private String phoneNumber;
    private String password;
}