package com.recancheros.users.services.impl;

import com.recancheros.users.config.jwt.JwtUtils;
import com.recancheros.users.model.dto.UserRequest;
import com.recancheros.users.model.dto.UserResponse;
import com.recancheros.users.model.entity.User;
import com.recancheros.users.model.mapper.UserMapper;
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
    private final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;
    private final JwtUtils jwtUtils;
    private final UserServiceImpl userService;

    @Override
    public UserResponse authenticate(UserRequest userRequest) throws Exception {

        UserResponse userResponse;
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userRequest.getUsername(),
                            userRequest.getPassword())
            );
        } catch (Exception e) {
            logger.error("Authentication failed {}", e);
            throw new Exception("Authentication failed", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(userRequest.getUsername());

        User user = userMapper.toEntity(userRequest);
        userResponse = userMapper.toUserResponse(user);

        userResponse.setJwt(jwtUtils.generateToken(userDetails));

        return userResponse;
    }


}
