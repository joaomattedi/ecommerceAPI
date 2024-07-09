package com.example.ecommerceapi.api.service;

import com.example.ecommerceapi.api.dto.UserDTO;
import com.example.ecommerceapi.api.model.User;
import com.example.ecommerceapi.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository _userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    public void registerUser(UserDTO userDTO) {
        String hashedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(hashedPassword);

        User user = new User();
        user.parse(userDTO);

        _userRepository.save(user);
    }

    public boolean authenticateUser(String email, String password){
        User user = _userRepository.findByEmailAddress(email);

        return user.getPassword().equals(password);
    }
}
