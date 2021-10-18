package repository.customer.Impl;

import bean.Customer;
import repository.BaseRepository;
import repository.customer.CustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select cus.* \n from customer cus\n" +
            "\tleft join customer_type cus_t on cus_t.customer_type_id=cus.customer_type_id;";
    private BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Customer> selectAllCus() throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int customer_id = resultSet.getInt("customer_id");
            int customer_type_id = resultSet.getInt("customer_type_id");
            String customer_name = resultSet.getString("customer_name");
            String customer_birthday = resultSet.getString("customer_birthday");
            String customer_gender = resultSet.getString("customer_gender");
            String customer_id_card = resultSet.getString("customer_id_card");
            String customer_phone = resultSet.getString("customer_phone");
            String customer_email = resultSet.getString("customer_email");
            String customer_address = resultSet.getString("customer_address");
            customerList.add(new Customer(customer_id,customer_type_id,customer_name,customer_birthday,
                    customer_gender,customer_id_card,customer_phone,customer_email,customer_address));
        }
        return customerList;
    }
}
