package model.repositories;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void delete(int id);

    List<Customer> findByContainName(String name);

    List<Customer> findByContainAddress(String address);

    List<Customer> findByContainTypeName(String typeName);

    List<Customer> findByContain(String name, String address, String typeName);

    void save(Customer customer);

    void update(Customer customer);

    Customer findById(int id);


}
