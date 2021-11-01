package model.service.impl;

import model.bean.Customer;
import model.repositories.CustomerRepository;
import model.repositories.impl.CustomerRepositoryImpl;
import model.service.CustomerService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void delete(int id) {
        customerRepository.delete(id);
    }

    @Override
    public List<Customer> findByContainName(String name) {
        return customerRepository.findByContainName(name);
    }

    @Override
    public List<Customer> findByContainAddress(String address) {
        return customerRepository.findByContainAddress(address);
    }

    @Override
    public List<Customer> findByContainTypeName(String typeName) {
        return customerRepository.findByContainTypeName(typeName);
    }


    @Override
    public List<Customer> findByContain(String name, String address, String typeName) {
        return customerRepository.findByContain(name, address, typeName);
    }

    @Override
    public Map<String, String> create(Customer customer) {
        Map<String, String> mapMessage = new HashMap<>();
        customerRepository.save(customer);
        return mapMessage;
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public Map<String, String> edit(Customer customer) {
        Map<String, String> mapMessage = new HashMap<>();
        customerRepository.update(customer);
        return mapMessage;
    }


}
