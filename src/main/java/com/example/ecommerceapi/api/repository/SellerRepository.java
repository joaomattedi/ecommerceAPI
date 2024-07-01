package com.example.ecommerceapi.api.repository;

import com.example.ecommerceapi.api.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Long> {
}
