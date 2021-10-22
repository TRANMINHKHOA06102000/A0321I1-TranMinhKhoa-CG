package model.repository.user.impl;

import model.bean.User;
import model.repository.BaseRepository;
import model.repository.user.UserRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserRepoImpl implements UserRepo {
    private static final String SELECT_USER_BY_ID_SQL = "select * from users where id=?";

    private static final String SELECT_AUTO_ID = "SELECT last_insert_id() FROM information_schema.tables " +
            "WHERE table_name = 'users' and table_schema = 'demo';";

    private static final String SELECT_AUTO_INCREMENT = "SELECT AUTO_INCREMENT FROM information_schema.tables " +
            "WHERE table_name = 'users' and table_schema = 'demo';";

    private static final String FIND_USER_BY_NAME_SQL = "select * from users where `name`=?";
    private static final String INSERT_USER_SQL = "insert into users(`name`, email, country) values(?,?,?)";
    private static final String UPDATE_USER_BY_ID_SQL = "update users set `name`=?,email=?,country=? where id=?";
    private static final String DELETE_USER_BY_ID_SQL = "delete from users where id = ?";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public boolean insertUser(User user)  {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    (INSERT_USER_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                    (SELECT_USER_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = baseRepository.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            User user = null;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setCountry(resultSet.getString("country"));
                user.setEmail(resultSet.getString("email"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement
                (DELETE_USER_BY_ID_SQL);
        preparedStatement.setInt(1, id);
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(UPDATE_USER_BY_ID_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            row = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public List<User> findUser(String name) {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement=baseRepository.getConnection().prepareStatement(FIND_USER_BY_NAME_SQL);
            preparedStatement.setString(1,name);
            User user=null;
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return userList;

    }

    @Override
    public int getIdAuto() {
        int id=0;
        try {
            Statement statement=baseRepository.getConnection().createStatement();
            ResultSet rs=statement.executeQuery(SELECT_AUTO_ID);
            while (rs.next()){
                id=rs.getInt("last_insert_id()");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return id+1;
    }
}
