package com.codegym.customermanage.service;

import com.codegym.customermanage.model.Customer;
import com.codegym.customermanage.model.Province;

public interface CustomerService {
    Iterable<Customer> findAll() throws Exception;

    Customer findById(Long id) throws Exception;

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
