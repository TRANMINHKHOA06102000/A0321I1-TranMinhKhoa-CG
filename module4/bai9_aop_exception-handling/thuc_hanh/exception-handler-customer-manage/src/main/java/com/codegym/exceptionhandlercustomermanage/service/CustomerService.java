package com.codegym.exceptionhandlercustomermanage.service;

import com.codegym.exceptionhandlercustomermanage.model.Customer;
import com.codegym.exceptionhandlercustomermanage.model.Province;
import com.codegym.exceptionhandlercustomermanage.service.impl.DuplicateEmailException;

public interface CustomerService {
    Iterable<Customer> findAll() throws Exception;

    Customer findById(Long id) throws Exception;

    Customer save(Customer customer) throws DuplicateEmailException;

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Province province);
}
