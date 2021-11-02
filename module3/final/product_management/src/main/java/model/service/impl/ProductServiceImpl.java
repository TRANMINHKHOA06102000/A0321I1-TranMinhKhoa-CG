package model.service.impl;

import model.bean.Product;
import model.repositories.ProductRepositories;
import model.repositories.impl.ProductRepositoriesImpl;
import model.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    ProductRepositories productRepositoies=new ProductRepositoriesImpl();
    @Override
    public List<Product> findAll() {
        return productRepositoies.findAll();
    }

    @Override
    public void delete(int id) {
        productRepositoies.delete(id);
    }

    @Override
    public Map<String, String> create(Product product) {
        Map<String, String> mapMessage = new HashMap<>();
        productRepositoies.save(product);
        return mapMessage;
    }

    @Override
    public List<Product> findByContain(String name, String price, String category, String color) {
        return productRepositoies.findByContain(name,price,category,color);
    }
}
