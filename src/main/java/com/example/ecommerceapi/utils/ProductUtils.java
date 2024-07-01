package com.example.ecommerceapi.utils;

import com.example.ecommerceapi.api.dto.ProductDTO;

public class ProductUtils {
    public static boolean validateCreateProduct(ProductDTO product) {
        if (product.getCodProduct() == null || product.getCodProduct().isEmpty()) {
            return false;
        }
        if (product.getName() == null) {
            return false;
        }
        if (product.getPrice() == null) {
            return false;
        }
        if (product.getSellerId() == null) {
            return false;
        }
        return true;
    }
}
