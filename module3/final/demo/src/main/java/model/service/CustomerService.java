package model.service;

import model.bean.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {
    List<Customer> findAll();

    void delete(int id);

    List<Customer> findByContainName(String name);

    List<Customer> findByContainAddress(String address);

    List<Customer> findByContainTypeName(String typeName);

    List<Customer> findByContain(String name, String address, String typeName);

    Map<String, String> create(Customer customer);

    Customer findById(int id);

    Map<String, String> edit(Customer customer);

}
