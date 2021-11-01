package model.repositories.impl;

import model.bean.Customer;
import model.repositories.CustomerRepository;
import model.repositories.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {
    private static final String SELECT_ALL = "SELECT * FROM customer " +
            "inner join customer_type on customer_type.customer_type_id = customer.customer_type_id;";
    private static final String DELETE_SQL = "delete from customer where customer_id =?;";
    private static final String SELECT_BY_CONTAIN_NAME = "SELECT * FROM customer " +
            "inner join customer_type on customer_type.customer_type_id = customer.customer_type_id" +
            " WHERE customer_name LIKE ?";
    private static final String SELECT_BY_CONTAIN_ADDRESS = "SELECT * FROM customer " +
            "inner join customer_type on customer_type.customer_type_id = customer.customer_type_id" +
            " WHERE customer_address LIKE ?";
    private static final String SELECT_BY_CONTAIN_TYPENAME = "SELECT * FROM customer " +
            "inner join customer_type on customer_type.customer_type_id = customer.customer_type_id" +
            " WHERE customer_type_name LIKE ?";
    private static final String SELECT_BY_CONTAIN = "select * from customer inner join customer_type on customer.customer_type_id=customer_type.customer_type_id\n" +
            "where customer.customer_name = ? and customer.customer_address = ? and customer_type.customer_type_name = ?;";
    private static final String INSERT_SQL = "insert into customer(customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)" +
            "values (?,?,?,?,?,?,?,?)";
    private static final String FIND_BY_ID = "select * from customer where customer_id = ?;";
    private static final String UPDATE_SQL = "update customer set customer_type_id = ?, " +
            "customer_name = ?, customer_birthday = ?,customer_gender = ?, customer_id_card = ?, " +
            "customer_phone = ?, customer_email = ?, customer_address = ? where customer_id = ?;";

    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.getConnection();
        List<Customer> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int customer_id = resultSet.getInt("customer_id");
                    String customer_name = resultSet.getString("customer_name");
                    String customer_birthday = resultSet.getString("customer_birthday");
                    Boolean customer_gender = resultSet.getBoolean("customer_gender");
                    String customer_id_card = resultSet.getString("customer_id_card");
                    String customer_phone = resultSet.getString("customer_phone");
                    String customer_email = resultSet.getString("customer_email");
                    String customer_address = resultSet.getString("customer_address");
                    String customer_type_name = resultSet.getString("customer_type_name");
                    list.add(new Customer(customer_id, customer_name, customer_birthday, customer_gender,
                            customer_id_card, customer_phone, customer_email, customer_address, customer_type_name));
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
    public List<Customer> findByContainName(String name) {
        Connection connection = DBConnection.getConnection();
        List<Customer> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CONTAIN_NAME);
                preparedStatement.setString(1, "%" + name + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int customer_id = resultSet.getInt("customer_id");
                    String customer_name = resultSet.getString("customer_name");
                    String customer_birthday = resultSet.getString("customer_birthday");
                    Boolean customer_gender = resultSet.getBoolean("customer_gender");
                    String customer_id_card = resultSet.getString("customer_id_card");
                    String customer_phone = resultSet.getString("customer_phone");
                    String customer_email = resultSet.getString("customer_email");
                    String customer_address = resultSet.getString("customer_address");
                    String customer_type_name = resultSet.getString("customer_type_name");
                    list.add(new Customer(customer_id, customer_name, customer_birthday, customer_gender,
                            customer_id_card, customer_phone, customer_email, customer_address, customer_type_name));
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
    public List<Customer> findByContainAddress(String address) {
        Connection connection = DBConnection.getConnection();
        List<Customer> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CONTAIN_ADDRESS);
                preparedStatement.setString(1, "%" + address + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int customer_id = resultSet.getInt("customer_id");
                    String customer_name = resultSet.getString("customer_name");
                    String customer_birthday = resultSet.getString("customer_birthday");
                    Boolean customer_gender = resultSet.getBoolean("customer_gender");
                    String customer_id_card = resultSet.getString("customer_id_card");
                    String customer_phone = resultSet.getString("customer_phone");
                    String customer_email = resultSet.getString("customer_email");
                    String customer_address = resultSet.getString("customer_address");
                    String customer_type_name = resultSet.getString("customer_type_name");
                    list.add(new Customer(customer_id, customer_name, customer_birthday, customer_gender,
                            customer_id_card, customer_phone, customer_email, customer_address, customer_type_name));
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
    public List<Customer> findByContainTypeName(String typeName) {
        Connection connection = DBConnection.getConnection();
        List<Customer> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CONTAIN_TYPENAME);
                preparedStatement.setString(1, "%" + typeName + "%");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int customer_id = resultSet.getInt("customer_id");
                    String customer_name = resultSet.getString("customer_name");
                    String customer_birthday = resultSet.getString("customer_birthday");
                    Boolean customer_gender = resultSet.getBoolean("customer_gender");
                    String customer_id_card = resultSet.getString("customer_id_card");
                    String customer_phone = resultSet.getString("customer_phone");
                    String customer_email = resultSet.getString("customer_email");
                    String customer_address = resultSet.getString("customer_address");
                    String customer_type_name = resultSet.getString("customer_type_name");
                    list.add(new Customer(customer_id, customer_name, customer_birthday, customer_gender,
                            customer_id_card, customer_phone, customer_email, customer_address, customer_type_name));
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
    public List<Customer> findByContain(String name, String address, String typeName) {
        Connection connection = DBConnection.getConnection();
        List<Customer> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_CONTAIN);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, address);
                preparedStatement.setString(3, typeName);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int customer_id = resultSet.getInt("customer_id");
                    String customer_name = resultSet.getString("customer_name");
                    String customer_birthday = resultSet.getString("customer_birthday");
                    Boolean customer_gender = resultSet.getBoolean("customer_gender");
                    String customer_id_card = resultSet.getString("customer_id_card");
                    String customer_phone = resultSet.getString("customer_phone");
                    String customer_email = resultSet.getString("customer_email");
                    String customer_address = resultSet.getString("customer_address");
                    String customer_type_name = resultSet.getString("customer_type_name");
                    list.add(new Customer(customer_id, customer_name, customer_birthday, customer_gender,
                            customer_id_card, customer_phone, customer_email, customer_address, customer_type_name));
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
    public void save(Customer customer) {
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
                preparedStatement.setInt(1, customer.getCustomer_type_id());
                preparedStatement.setString(2, customer.getCustomer_name());
                preparedStatement.setString(3, customer.getCustomer_birthday());
                preparedStatement.setBoolean(4, customer.getCustomer_gender());
                preparedStatement.setString(5, customer.getCustomer_id_card());
                preparedStatement.setString(6, customer.getCustomer_phone());
                preparedStatement.setString(7, customer.getCustomer_email());
                preparedStatement.setString(8, customer.getCustomer_address());
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
    public void update(Customer customer) {
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
                preparedStatement.setInt(1, customer.getCustomer_type_id());
                preparedStatement.setString(2, customer.getCustomer_name());
                preparedStatement.setString(3, customer.getCustomer_birthday());
                preparedStatement.setBoolean(4, customer.getCustomer_gender());
                preparedStatement.setString(5, customer.getCustomer_id_card());
                preparedStatement.setString(6, customer.getCustomer_phone());
                preparedStatement.setString(7, customer.getCustomer_email());
                preparedStatement.setString(8, customer.getCustomer_address());
                preparedStatement.setInt(9, customer.getCustomer_id());
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    customer = new Customer();
                    customer.setCustomer_id(resultSet.getInt("customer_id"));
                    customer.setCustomer_type_id(resultSet.getInt("customer_type_id"));
                    customer.setCustomer_name(resultSet.getString("customer_name"));
                    customer.setCustomer_birthday(resultSet.getString("customer_birthday"));
                    customer.setCustomer_gender(resultSet.getBoolean("customer_gender"));
                    customer.setCustomer_id_card(resultSet.getString("customer_id_card"));
                    customer.setCustomer_phone(resultSet.getString("customer_phone"));
                    customer.setCustomer_email(resultSet.getString("customer_email"));
                    customer.setCustomer_address(resultSet.getString("customer_address"));
                }
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
        return customer;
    }


}
