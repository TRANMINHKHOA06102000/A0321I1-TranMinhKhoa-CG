package model.service;

import model.bean.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();

    void delete(int id);

    List<Customer> findByContainName(String name);

    Map<String, String> create(Customer customer);

}
