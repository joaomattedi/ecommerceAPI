package com.example.ecommerceapi.utils;

import com.example.ecommerceapi.api.dto.UserDTO;

public class UserUtils {
    public static boolean validRegisterUser(UserDTO userDTO) {
        if (userDTO.getName().isBlank()) return false;
        if (userDTO.getEmail().isBlank()) return false;
        if (userDTO.getPassword().isBlank()) return false;
        return !userDTO.getPhoneNumber().isBlank() || !userDTO.getCellphoneNumber().isBlank();
    }
}
