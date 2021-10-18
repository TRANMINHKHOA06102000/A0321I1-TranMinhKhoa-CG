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
    private static final String SELECT_ALL_CUSTOMER = "select customer.* from customer " +
            "left join customer_type on customer_type.customer_type_id=customer.customer_type_id;";
    private static final String INSERT_CUSTOMER_SQL = "insert into customer(customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)" +
            "values (?,?,?,b?,?,?,?,?)";
    private static final String FIND_CUSTOMER_BY_NAME_SQL = "select customer.* from customer " +
            "left join customer_type on customer_type.customer_type_id=customer.customer_type_id " +
            "where ((customer.customer_name like ?));";

    private static final String DELETE_CUSTOMER_BY_ID_SQL = "delete from customer where customer_id =?;";

    private static final String SELECT_CUSTOMER_BY_ID_SQL = "select customer.* from customer " +
            "left join customer_type on customer_type.customer_type_id=customer.customer_type_id " +
            "where customer.customer_id=?;";
    private static final String UPDATE_CUSTOMER_BY_ID_SQL = "update customer " +
            "set customer_type_id=?,customer_name=?,customer_birthday=?,customer_gender=?" +
            ",customer_id_card=?,customer_phone=?,customer_email=?,customer_address=?" +
            "where customer.customer_id=?;";

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
            customerList.add(new Customer(customer_id, customer_type_id, customer_name, customer_birthday,
                    customer_gender, customer_id_card, customer_phone, customer_email, customer_address));
        }
        return customerList;
    }

    @Override
    public boolean insertCus(Customer customer) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_CUSTOMER_SQL);
        preparedStatement.setInt(1, customer.getCustomer_type_id());
        preparedStatement.setString(2, customer.getCustomer_name());
        preparedStatement.setString(3, customer.getCustomer_birthday());
        preparedStatement.setString(4, customer.getCustomer_gender());
        preparedStatement.setString(5, customer.getCustomer_id_card());
        preparedStatement.setString(6, customer.getCustomer_phone());
        preparedStatement.setString(7, customer.getCustomer_email());
        preparedStatement.setString(8, customer.getCustomer_address());
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public boolean deleteCus(int idCus) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(DELETE_CUSTOMER_BY_ID_SQL);
        preparedStatement.setInt(1, idCus);
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public Customer selectCus(int id) throws SQLException {
        Customer customer = null;
        PreparedStatement statement = this.baseRepository.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID_SQL);
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            customer = new Customer();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setCustomer_type_id(rs.getInt("customer_type_id"));
            customer.setCustomer_name(rs.getString("customer_name"));
            customer.setCustomer_birthday(rs.getString("customer_birthday"));
            customer.setCustomer_gender(rs.getString("customer_gender"));
            customer.setCustomer_id_card(rs.getString("customer_id_card"));
            customer.setCustomer_phone(rs.getString("customer_phone"));
            customer.setCustomer_email(rs.getString("customer_email"));
            customer.setCustomer_address(rs.getString("customer_address"));
        }
        return customer;
    }

    @Override
    public boolean updateCus(Customer customer) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(UPDATE_CUSTOMER_BY_ID_SQL);
        preparedStatement.setInt(1, customer.getCustomer_type_id());
        preparedStatement.setString(2, customer.getCustomer_name());
        preparedStatement.setString(3, customer.getCustomer_birthday());
        preparedStatement.setString(4, customer.getCustomer_gender());
        preparedStatement.setString(5, customer.getCustomer_id_card());
        preparedStatement.setString(6, customer.getCustomer_phone());
        preparedStatement.setString(7, customer.getCustomer_email());
        preparedStatement.setString(8, customer.getCustomer_address());
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public List<Customer> findCus(String nameCus) throws SQLException {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(FIND_CUSTOMER_BY_NAME_SQL);
        preparedStatement.setString(1, "%" + nameCus + "%");
        ResultSet rs = preparedStatement.executeQuery();
        Customer customer = null;
        while (rs.next()) {
            customer = new Customer();
            customer.setCustomer_id(rs.getInt("customer_id"));
            customer.setCustomer_type_id(rs.getInt("customer_type_id"));
            customer.setCustomer_name(rs.getString("customer_name"));
            customer.setCustomer_birthday(rs.getString("customer_birthday"));
            customer.setCustomer_gender(rs.getString("customer_gender"));
            customer.setCustomer_id_card(rs.getString("customer_id_card"));
            customer.setCustomer_phone(rs.getString("customer_phone"));
            customer.setCustomer_email(rs.getString("customer_email"));
            customer.setCustomer_address(rs.getString("customer_address"));
            customerList.add(customer);
        }
        return customerList;
    }
}
