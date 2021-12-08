package com.codegym.createshoppingcart.service.impl;

import com.codegym.createshoppingcart.model.Product;
import com.codegym.createshoppingcart.repository.ProductRepository;
import com.codegym.createshoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }
}
