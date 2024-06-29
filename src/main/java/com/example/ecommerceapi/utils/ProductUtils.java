package com.example.ecommerceapi.utils;

import com.example.ecommerceapi.api.models.Product;

public class ProductUtils {
    public static boolean validateCreateProduct(Product product) {
        if (product.getCodProduct() == null) {
            return false;
        }
        if (product.getName() == null) {
            return false;
        }
        if (product.getPrice() == null) {
            return false;
        }
        if (product.getSeller() == null) {
            return false;
        }
        return true;
    }
}
