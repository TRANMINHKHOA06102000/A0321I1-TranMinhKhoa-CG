package com.codegym.createshoppingcart.repository;

import com.codegym.createshoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
