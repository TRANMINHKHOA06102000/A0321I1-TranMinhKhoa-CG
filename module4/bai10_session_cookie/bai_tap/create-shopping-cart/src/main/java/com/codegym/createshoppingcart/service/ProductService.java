package com.codegym.createshoppingcart.service;

import com.codegym.createshoppingcart.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
