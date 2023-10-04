package com.recancheros.users.services;

import com.recancheros.users.exceptions.UserAlreadyExistsException;
import com.recancheros.users.exceptions.UserNotFoundException;
import com.recancheros.users.model.dto.UserRequest;
import com.recancheros.users.model.dto.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void createUser(UserRequest userRequest) throws UserAlreadyExistsException;
    Optional<UserResponse> getUserById(Long id) throws UserNotFoundException;
    List<UserResponse> getAllUsers();
    String getRoleByUserName(String username);
}
