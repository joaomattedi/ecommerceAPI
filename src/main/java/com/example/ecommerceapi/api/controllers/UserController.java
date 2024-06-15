package com.example.ecommerceapi.api.controllers;

import com.example.ecommerceapi.api.models.User;
import com.example.ecommerceapi.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {

    private final IUserService _userService;

    @Autowired
    public UserController(IUserService userService) {
        _userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam int uuid) {
        Optional<User> user = _userService.get(uuid);

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }
}
