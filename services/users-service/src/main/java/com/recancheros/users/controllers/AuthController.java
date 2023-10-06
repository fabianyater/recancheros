package com.recancheros.users.controllers;

import com.recancheros.users.model.dto.UserRequest;
import com.recancheros.users.model.dto.UserResponse;
import com.recancheros.users.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    public ResponseEntity<UserResponse> authenticate(@RequestBody UserRequest userRequest) throws Exception {
        UserResponse userResponse = authService.authenticate(userRequest);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
