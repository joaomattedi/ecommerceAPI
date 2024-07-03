package com.example.ecommerceapi.api.controller;

import com.example.ecommerceapi.api.dto.UserDTO;
import com.example.ecommerceapi.api.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService _userService;

    public void UserController(UserService userService) {
        _userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserDTO userDto) {

        return ResponseEntity.ok().build();
    }

}
