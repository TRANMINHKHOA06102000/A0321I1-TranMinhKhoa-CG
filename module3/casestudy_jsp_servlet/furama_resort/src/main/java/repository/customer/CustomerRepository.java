package repository.customer;

import bean.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    List<Customer> selectAllCus() throws SQLException;

    boolean insertCus(Customer customer) throws SQLException;

    boolean deleteCus(int idCus) throws SQLException;

    Customer selectCus(int id) throws SQLException;

    boolean updateCus(Customer customer) throws SQLException;

    List<Customer> findCus(String nameCus) throws SQLException;
}
