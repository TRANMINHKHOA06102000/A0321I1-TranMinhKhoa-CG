package service.customer.Impl;

import bean.Customer;
import repository.customer.CustomerRepository;
import repository.customer.Impl.CustomerRepositoryImpl;
import service.customer.CustomerService;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository=new CustomerRepositoryImpl();
    @Override
    public List<Customer> selectAllCus() throws SQLException {
        return customerRepository.selectAllCus();
    }
}
