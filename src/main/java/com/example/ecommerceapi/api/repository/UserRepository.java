package com.example.ecommerceapi.api.repository;

import com.example.ecommerceapi.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from users u where u.email = ?1")
    User findByEmailAddress(String emailAddress);
}
