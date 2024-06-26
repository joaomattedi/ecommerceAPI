package com.example.ecommerceapi.api.controllers;

import com.example.ecommerceapi.api.models.Product;
import com.example.ecommerceapi.api.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public ResponseEntity getAllProducts() {
        return ResponseEntity.ok(this.productRepository.findAll());
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{codProduct}")
    public ResponseEntity getSingleProduct(@PathVariable String codProduct) {
        Product teste = productRepository.findProductByCodProduct(codProduct).stream().findFirst().orElse(null);
        if (teste == null){
            return ResponseEntity.ok("[]");
        }
        return ResponseEntity.ok(teste.toString());
    }
}
