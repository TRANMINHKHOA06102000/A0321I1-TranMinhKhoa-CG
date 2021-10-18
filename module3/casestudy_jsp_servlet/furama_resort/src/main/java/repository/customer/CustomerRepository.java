package repository.customer;

import bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    List<Customer> selectAllCus() throws SQLException;
}
