package com.recancheros.users.services;

import com.recancheros.users.exceptions.AuthenticationFailedException;
import com.recancheros.users.model.dto.UserRequest;
import com.recancheros.users.model.dto.UserResponse;

public interface AuthService {
    UserResponse authenticate(UserRequest userRequest) throws AuthenticationFailedException;
}
