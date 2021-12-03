package com.codegym.exceptionhandlercustomermanage.service.impl;

import com.codegym.exceptionhandlercustomermanage.model.Customer;
import com.codegym.exceptionhandlercustomermanage.model.Province;
import com.codegym.exceptionhandlercustomermanage.repository.CustomerRepository;
import com.codegym.exceptionhandlercustomermanage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }
//    @Override
//    public Iterable<Customer> findAll() throws Exception{
//        if (true) throw new Exception("a dummy exception");
//        return customerRepository.findAll();
//    }

    //    @Override
//    public Customer findById(Long id) {
//        return customerRepository.findById(id).orElse(null);
//    }
    @Override
    public Customer findById(Long id) throws Exception {
        Customer target=customerRepository.findById(id).orElse(null);
        if (target == null) {
            throw new Exception("customer not found!");
        }
        return target;
    }

    @Override
    public Customer save(Customer customer) throws DuplicateEmailException {
        try {
            return customerRepository.save(customer);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicateEmailException();
        }
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }
}
