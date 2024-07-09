package com.example.ecommerceapi.api.controller;

import com.example.ecommerceapi.api.dto.UserDTO;
import com.example.ecommerceapi.api.service.UserService;
import com.example.ecommerceapi.utils.UserUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserDTO userDto) {
        if (!UserUtils.validRegisterUser(userDto)) {
            return ResponseEntity.badRequest().body("User register body is incomplete. Review your information.");
        }

        _userService.registerUser(userDto);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity authenticateUser(@RequestBody UserDTO userDTO){
        boolean valid = _userService.authenticateUser(userDTO.getEmail(),userDTO.getPassword());

        if (!valid) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }

        return ResponseEntity.ok().build();
    }
}
