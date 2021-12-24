package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.jpa.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto getUserByUserId(String userId);
    UserDto getUserDetailsByUserEmail(String userId);
    Iterable<UserEntity> getUserByAll();
}
