package reponsitory;

import model.Product;

import java.util.List;

public interface ProductReponsitory {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update(Integer id, Product product);

    void remove(Integer id);

    List<Product> findByName(String name);;
}
