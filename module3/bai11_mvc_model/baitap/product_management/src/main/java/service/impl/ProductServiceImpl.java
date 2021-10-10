package service.impl;

import model.Product;
import reponsitory.ProductReponsitory;
import reponsitory.impl.ProductReponsitoryImpl;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductReponsitory productReponsitory = new ProductReponsitoryImpl();

    @Override
    public List<Product> findAll() {
        return productReponsitory.findAll();
    }

    @Override
    public void save(Product product) {
        productReponsitory.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productReponsitory.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productReponsitory.update(id, product);
    }

    @Override
    public void remove(Integer id) {
        productReponsitory.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productReponsitory.findByName(name);
    }
}
