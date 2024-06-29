package com.example.ecommerceapi.api.controllers;

import com.example.ecommerceapi.api.models.Product;
import com.example.ecommerceapi.api.repository.ProductRepository;
import com.example.ecommerceapi.api.services.ProductService;
import com.example.ecommerceapi.utils.ProductUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService _productService;

    public ProductController(ProductService productService) {
        _productService = productService;
    }

    @GetMapping
    public ResponseEntity getAllProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(_productService.getAllProducts(page,size,sortBy));
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        if (ProductUtils.validateCreateProduct(product)) {
            return ResponseEntity.badRequest().body("Review the information from body request.");
        }
        Product newProduct = _productService.createProduct(product);
        return ResponseEntity.ok(newProduct);
    }

//    @GetMapping("/{codProduct}")
//    public ResponseEntity getSingleProduct(@PathVariable String codProduct) {
//    }
}
