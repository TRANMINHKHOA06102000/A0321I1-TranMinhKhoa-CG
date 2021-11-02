package model.repositories.impl;

import model.bean.Category;
import model.repositories.CategoryRepositories;
import model.repositories.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoriesImpl implements CategoryRepositories {
    private static final String SELECT_ALL_SQL = "SELECT * FROM category;";
    @Override
    public List<Category> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Category> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int category_id = resultSet.getInt("category_id");
                    String category_name = resultSet.getString("category_name");
                    list.add(new Category(category_id, category_name));
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
