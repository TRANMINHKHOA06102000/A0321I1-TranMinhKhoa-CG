package service.customer;


import bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    List<Customer> selectAllCus() throws SQLException;
}
