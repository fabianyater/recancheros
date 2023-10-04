package com.recancheros.users.model.dto;

import com.recancheros.users.feign.SportCenterDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserResponse {
    private String fullName;
    private String username;
    private String email;
    private String phoneNumber;
    private String jwt;
    private String role;
}
