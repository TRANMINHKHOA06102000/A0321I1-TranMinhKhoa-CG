package model.service;

import model.bean.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    List<Product> findAll();

    void delete(int id);

    Map<String, String> create(Product product);

    List<Product> findByContain(String name, String  price, String category, String color);
}
