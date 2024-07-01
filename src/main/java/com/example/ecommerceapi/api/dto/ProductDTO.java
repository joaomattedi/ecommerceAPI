package com.example.ecommerceapi.api.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private String codProduct;
    private String name;
    private String description;
    private Double price;
    private Long sellerId;
}
