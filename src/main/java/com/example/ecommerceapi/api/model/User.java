package com.example.ecommerceapi.api.model;

import com.example.ecommerceapi.api.dto.UserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false)
    private UUID uuid;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String phoneNumber;

    private String cellphoneNumber;

    public void parse(UserDTO userDTO) {
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
        this.password = userDTO.getPassword();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.cellphoneNumber = userDTO.getCellphoneNumber();
    }
}
