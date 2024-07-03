package com.example.ecommerceapi.api.service;

import com.example.ecommerceapi.api.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository _userRepository;

    public void UserRepository(UserRepository userRepository){
        _userRepository = userRepository;
    }
}
