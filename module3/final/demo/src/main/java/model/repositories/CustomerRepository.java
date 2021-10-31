package model.repositories;

import model.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    void delete(int id);

    List<Customer> findByContainName(String name);

    void save(Customer customer);

}
