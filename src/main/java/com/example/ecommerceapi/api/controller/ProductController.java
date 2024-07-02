package com.example.ecommerceapi.api.controller;

import com.example.ecommerceapi.api.dto.ProductDTO;
import com.example.ecommerceapi.api.model.Product;
import com.example.ecommerceapi.api.service.ProductService;
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
    public ResponseEntity createProduct(@RequestBody ProductDTO productDTO) {
        if (!ProductUtils.validateCreateProduct(productDTO)) {
            return ResponseEntity.badRequest().body("Review the information from body request.");
        }
        Product newProduct = _productService.createProduct(productDTO);
        return ResponseEntity.ok(newProduct);
    }

    @GetMapping("/{codProduct}")
    public ResponseEntity getProductByCodProduct(@PathVariable String codProduct) {
        return ResponseEntity.ok(_productService.getProductByCodProduct(codProduct));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id,@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(_productService.updateProduct(id,productDTO));
    }
}
