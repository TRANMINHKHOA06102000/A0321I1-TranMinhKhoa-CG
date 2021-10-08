package service.impl;

import model.Customer;
import reponsitory.CustomerReponsitory;
import reponsitory.impl.CustomerReponsitoryImpl;
import service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerReponsitory customerReponsitory = new CustomerReponsitoryImpl();

    @Override
    public List<Customer> findAll() {
        return customerReponsitory.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerReponsitory.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerReponsitory.findById(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerReponsitory.update(id, customer);
    }

    @Override
    public void remove(int id) {
        customerReponsitory.remove(id);
    }
}
