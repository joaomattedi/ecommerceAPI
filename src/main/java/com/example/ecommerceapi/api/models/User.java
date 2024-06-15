package com.example.ecommerceapi.api.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
public class User {
    private int uuid;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private Timestamp birth_date;

    public User(int uuid, String name, String email, String password, String phoneNumber, Timestamp birthDate) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone_number = phoneNumber;
        this.birth_date = birthDate;
    }
}
