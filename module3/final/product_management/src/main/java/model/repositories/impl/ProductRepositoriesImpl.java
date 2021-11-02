package model.repositories.impl;

import model.bean.Product;
import model.repositories.DBConnection;
import model.repositories.ProductRepositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoriesImpl implements ProductRepositories {
    private static final String SELECT_ALL = "SELECT * FROM product " +
            "inner join category on category.category_id = product.category_id;";
    private static final String DELETE_SQL = "delete from product where product_id =?;";
    private static final String INSERT_SQL = "insert into product(product_name,product_price," +
            "product_quantity,product_color,product_description,category_id)" +
            "values (?,?,?,?,?,?)";
    private static final String SELECT_CONTAIN = "select * from product inner join category on product.category_id=category.category_id \n" +
            "where product.product_name like ? and category.category_name like ? \n" +
            "and product.product_color like ?;";

    @Override
    public List<Product> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Product> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int product_id = resultSet.getInt("product_id");
                    String product_name = resultSet.getString("product_name");
                    Double product_price = resultSet.getDouble("product_price");
                    int product_quantity = resultSet.getInt("product_quantity");
                    String product_color = resultSet.getString("product_color");
                    String product_description = resultSet.getString("product_description");
                    String category_name = resultSet.getString("category_name");
                    list.add(new Product(product_id, product_name, product_price, product_quantity, product_color,
                            product_description, category_name));
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

    @Override
    public void delete(int id) {
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public void save(Product product) {
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
                preparedStatement.setString(1, product.getProduct_name());
                preparedStatement.setDouble(2, product.getProduct_price());
                preparedStatement.setInt(3, product.getProduct_quantity());
                preparedStatement.setString(4, product.getProduct_color());
                preparedStatement.setString(5, product.getProduct_description());
                preparedStatement.setInt(6, product.getCategory_id());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Product> findByContain(String name, String price, String category, String color) {
        Connection connection = DBConnection.getConnection();
        List<Product> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CONTAIN);
                preparedStatement.setString(1, "%" + name + "%");
//                preparedStatement.setString(2, price);
                preparedStatement.setString(2, "%" + category + "%");
                preparedStatement.setString(3, "%" + color + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int product_id = resultSet.getInt("product_id");
                    String product_name = resultSet.getString("product_name");
                    Double product_price = resultSet.getDouble("product_price");
                    int product_quantity = resultSet.getInt("product_quantity");
                    String product_color = resultSet.getString("product_color");
                    String product_description = resultSet.getString("product_description");
                    String category_name = resultSet.getString("category_name");
                    list.add(new Product(product_id,product_name,product_price,product_quantity,
                            product_color,product_description,category_name));
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
