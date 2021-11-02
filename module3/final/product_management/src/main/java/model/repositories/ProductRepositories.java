package model.repositories;

import model.bean.Product;

import java.util.List;

public interface ProductRepositories {
    List<Product> findAll();

    void delete(int id);

    void save(Product product);

    List<Product> findByContain(String name, String  price, String category, String color);
}
