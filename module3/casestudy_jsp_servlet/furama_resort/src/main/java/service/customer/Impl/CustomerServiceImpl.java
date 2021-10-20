package service.customer.Impl;

import bean.Customer;
import repository.customer.CustomerRepository;
import repository.customer.Impl.CustomerRepositoryImpl;
import service.customer.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> selectAllCus() throws SQLException {
        return customerRepository.selectAllCus();
    }

    @Override
    public boolean insertCus(Customer customer) throws SQLException {
        return customerRepository.insertCus(customer);
    }

    @Override
    public boolean deleteCus(int idCus) throws SQLException {
        return customerRepository.deleteCus(idCus);
    }

    @Override
    public Customer selectCus(int id) throws SQLException {
        return customerRepository.selectCus(id);
    }

    @Override
    public boolean updateCus(Customer customer) throws SQLException {
        return customerRepository.updateCus(customer);
    }

    @Override
    public List<Customer> findCus(String nameCus) throws SQLException {
        return customerRepository.findCus(nameCus);
    }
}
