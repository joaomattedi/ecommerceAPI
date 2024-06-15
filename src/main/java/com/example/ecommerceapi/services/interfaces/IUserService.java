package com.example.ecommerceapi.services.interfaces;

import com.example.ecommerceapi.api.models.User;

import java.util.Optional;
import java.util.UUID;

public interface IUserService {

    public User create();
    public void delete();
    public User edit();
    public Optional<User> get(int uuid);
}
