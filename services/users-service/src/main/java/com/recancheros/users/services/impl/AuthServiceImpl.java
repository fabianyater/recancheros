package com.recancheros.users.services.impl;

import com.recancheros.users.config.jwt.JwtUtils;
import com.recancheros.users.exceptions.AuthenticationFailedException;
import com.recancheros.users.model.dto.UserRequest;
import com.recancheros.users.model.dto.UserResponse;
import com.recancheros.users.services.AuthService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserServiceImpl userService;

    @Override
    public UserResponse authenticate(UserRequest userRequest) throws AuthenticationFailedException {

        UserResponse userResponse = new UserResponse();
        String role = userService.getRoleByUserName(userRequest.getUsername());
        final UserDetails userDetails = userService.loadUserByUsername(userRequest.getUsername());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userRequest.getUsername(),
                            userRequest.getPassword())
            );
        } catch (Exception e) {
            logger.error("Authentication failed {0}", e);
            throw new AuthenticationFailedException();
        }

        userResponse.setUsername(userRequest.getUsername());
        userResponse.setJwt(jwtUtils.generateToken(userDetails, role));
        userResponse.setRole(role);

        return userResponse;
    }


}
