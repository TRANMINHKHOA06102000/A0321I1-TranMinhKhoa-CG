package reponsitory.impl;

import model.Product;
import reponsitory.ProductReponsitory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductReponsitoryImpl implements ProductReponsitory {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Sách", 20000.0, "Giáo Khoa", "NXB TPHCM"));
        productMap.put(2, new Product(2, "Sách", 20000.0, "Tham Khảo", "NXB TPHCM"));
        productMap.put(3, new Product(3, "Sách", 20000.0, "Viễn Tưởng", "NXB TPHCM"));
        productMap.put(4, new Product(4, "Sách", 20000.0, "Động Vật", "NXB TPHCM"));
        productMap.put(5, new Product(5, "Sách", 20000.0, "Truyện Thiếu Nhi", "NXB TPHCM"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return productMap.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        productMap.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> find = new ArrayList<>();
        for (int i = 0; i < findAll().size(); i++) {
            if (findAll().get(i).getName().contains(name)) {
                find.add(findAll().get(i));
            }
        }
        return find;
    }
    /*@Override
    public List<Product> findByName(String name) {
        return productMap.values()
                .stream()
                .filter(cus -> cus.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }*/
}
