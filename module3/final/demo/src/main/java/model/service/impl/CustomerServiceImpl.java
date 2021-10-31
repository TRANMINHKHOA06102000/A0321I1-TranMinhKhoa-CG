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
    public Map<String, String> create(Customer customer) {
        Map<String, String> mapMessage = new HashMap<>();
//        if (Validator.validateDate(employee.getBirthday()) != null
//                || Validator.validateIdCard(employee.getIdCard()) != null
//                || Validator.validateInteger(employee.getSalary()) != null
//                || Validator.validatePhone(employee.getPhone()) != null
//                || Validator.validateEmail(employee.getEmail()) != null) {
//            mapMessage.put("birthday", Validator.validateDate(employee.getBirthday()));
//            mapMessage.put("idCard", Validator.validateIdCard(employee.getIdCard()));
//            mapMessage.put("salary", Validator.validateInteger(employee.getSalary()));
//            mapMessage.put("phone", Validator.validatePhone(employee.getPhone()));
//            mapMessage.put("email", Validator.validateEmail(employee.getEmail()));
//        } else {
//            employeeRepository.save(employee);
//        }
        customerRepository.save(customer);
        return mapMessage;
    }

}
