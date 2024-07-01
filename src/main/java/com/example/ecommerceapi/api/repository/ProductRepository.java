package com.example.ecommerceapi.api.repository;

import com.example.ecommerceapi.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT p FROM Product p WHERE p.codProduct = ?1")
    List<Product> findProductByCodProduct(String codProduct);
}
