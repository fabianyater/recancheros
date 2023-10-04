package com.recancheros.users.services.impl;

import com.recancheros.users.exceptions.UserAlreadyExistsException;
import com.recancheros.users.exceptions.UserNotFoundException;
import com.recancheros.users.model.dto.UserRequest;
import com.recancheros.users.model.dto.UserResponse;
import com.recancheros.users.model.entity.User;
import com.recancheros.users.model.mapper.UserMapper;
import com.recancheros.users.model.utils.RoleEnum;
import com.recancheros.users.repositories.UserRepository;
import com.recancheros.users.services.AuthService;
import com.recancheros.users.services.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(UserRequest userRequest) throws UserAlreadyExistsException {
        Optional<User> existingUser = userRepository.findByEmail(userRequest.getEmail());

        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        User user = userMapper.toEntity(userRequest);
        user.setPassword(bCryptPasswordEncoder.encode(userRequest.getPassword()));
        user.setRole(RoleEnum.USER.getMessage());
        userRepository.save(user);
    }

    @Override
    public Optional<UserResponse> getUserById(Long id) throws UserNotFoundException {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findById(id).orElseThrow(UserNotFoundException::new));

        UserResponse userResponse = null;
        if (userOptional.isPresent()) {
            userResponse = userMapper.toUserResponse(userOptional.get());
        }

        return Optional.ofNullable(userResponse);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }

    @Override
    public String getRoleByUserName(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        String role = null;

        if (user.isPresent()) {
            role = user.get().getRole();
        }

        return role;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);

        }
    }
}
