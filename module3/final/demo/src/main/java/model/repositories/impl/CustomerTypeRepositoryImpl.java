package model.repositories.impl;

import model.bean.CustomerType;
import model.repositories.CustomerTypeRepository;
import model.repositories.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {
    private static final String SELECT_ALL_SQL = "SELECT * FROM customer_type;";

    @Override
    public List<CustomerType> findALl() {
        Connection connection = DBConnection.getConnection();
        List<CustomerType> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int customer_type_id = resultSet.getInt("customer_type_id");
                    String customer_type_name = resultSet.getString("customer_type_name");
                    list.add(new CustomerType(customer_type_id, customer_type_name));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }
}
