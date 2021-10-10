package service.impl;

import model.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductService productService = new ProductServiceImpl();

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public void save(Product product) {
        productService.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productService.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productService.update(id, product);
    }

    @Override
    public void remove(Integer id) {
        productService.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productService.findByName(name);
    }
}
