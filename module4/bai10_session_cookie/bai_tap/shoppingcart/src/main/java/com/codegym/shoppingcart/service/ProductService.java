package com.codegym.shoppingcart.service;

import com.codegym.shoppingcart.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
}
