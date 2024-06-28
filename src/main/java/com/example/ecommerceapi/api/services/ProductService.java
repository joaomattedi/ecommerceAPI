package com.example.ecommerceapi.api.services;

import com.example.ecommerceapi.api.models.Product;
import com.example.ecommerceapi.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository _productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        _productRepository = productRepository;
    }

    public Page<Product> getAllProducts(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return _productRepository.findAll(pageable);
    }
}
