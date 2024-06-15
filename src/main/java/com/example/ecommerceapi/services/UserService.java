package com.example.ecommerceapi.services;

import com.example.ecommerceapi.api.models.User;
import com.example.ecommerceapi.services.interfaces.IUserService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class UserService implements IUserService {

    private List<User> inMemoryUserList;

    public UserService() {
        inMemoryUserList = new ArrayList<>();

        User user1 = new User(1,"Joe","joedoe@mail.com","123456", "554712341234", new Timestamp(new Date().getTime()));
        User user2 = new User(2,"Alice","alice@mail.com","123456", "554712341234", new Timestamp(new Date().getTime()));
        User user3 = new User(3,"Julia","julia@mail.com","123456", "554712341234", new Timestamp(new Date().getTime()));
        User user4 = new User(4,"Joao","joao@mail.com","123456", "554712341234", new Timestamp(new Date().getTime()));
        User user5 = new User(5,"Maike","maike@mail.com","123456", "554712341234", new Timestamp(new Date().getTime()));

        inMemoryUserList.addAll(Arrays.asList(user1,user2,user3,user4,user5));
    }

    @Override
    public User create() {
        return null;
    }

    @Override
    public void delete() {

    }

    @Override
    public User edit() {
        return null;
    }

    @Override
    public Optional<User> get(int uuid) {
        Optional<User> optional = Optional.empty();
        for (User user: inMemoryUserList) {
            if (uuid == user.getUuid()) optional = Optional.of(user);
        }
        return optional;
    }
}
