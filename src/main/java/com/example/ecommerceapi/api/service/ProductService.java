package com.example.ecommerceapi.api.service;

import com.example.ecommerceapi.api.dto.ProductDTO;
import com.example.ecommerceapi.api.model.Product;
import com.example.ecommerceapi.api.model.Seller;
import com.example.ecommerceapi.api.repository.ProductRepository;
import com.example.ecommerceapi.api.repository.SellerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository _productRepository;
    private final SellerRepository _sellerRepository;
    public ProductService(ProductRepository productRepository, SellerRepository sellerRepository) {
        _productRepository = productRepository;
        _sellerRepository = sellerRepository;
    }

    public Page<Product> getAllProducts(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        return _productRepository.findAll(pageable);
    }

    public Product getProductByCodProduct(String codProduct) {
        return _productRepository.findProductByCodProduct(codProduct).get(0);
    }

    public Product createProduct(ProductDTO productDto) {
        Product product = new Product();
        product.setCodProduct(productDto.getCodProduct());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());

        Seller seller = _sellerRepository.findById(productDto.getSellerId()).orElseThrow(() -> new IllegalArgumentException("Invalid seller ID"));
        product.setSeller(seller);

        return _productRepository.save(product);
    }
}
