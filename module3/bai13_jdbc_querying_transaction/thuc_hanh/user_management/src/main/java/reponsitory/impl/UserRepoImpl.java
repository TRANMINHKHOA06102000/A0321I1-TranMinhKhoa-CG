package reponsitory.impl;

import bean.User;
import reponsitory.BaseRepo;
import reponsitory.UserRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepoImpl implements UserRepo {
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String INSERT_USER_SQL = "insert into users(`name`, email, country) values(?,?,?)";
    private static final String SELECT_USER_BY_ID_SQL = "select * from users where id=?";
    private static final String UPDATE_USER_BY_ID_SQL = "update users set `name`=?,email=?,country=? where id=?";
    private static final String DELETE_USER_BY_ID_SQL = "delete from users where id = ?";
    private static final String FIND_USER_BY_COUNTRY_SQL = "select * from users where country=?";
    private static final String SELECT_ALL_USERS_SORT = "select * from users order by `name`";


    private BaseRepo baseRepo = new BaseRepo();

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            Statement statement = baseRepo.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
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
    public boolean insertUser(User user) throws SQLException {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepo.getConnection().prepareStatement(INSERT_USER_SQL);
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
        try {
            PreparedStatement preparedStatement = baseRepo.getConnection().prepareStatement(SELECT_USER_BY_ID_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
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
    public boolean updateUser(User user) throws SQLException {
        int row = 0;
        try {
            PreparedStatement preparedStatement = baseRepo.getConnection().prepareStatement(UPDATE_USER_BY_ID_SQL);
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
    public boolean deleteUser(int id) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = baseRepo.getConnection().prepareStatement(DELETE_USER_BY_ID_SQL);
        preparedStatement.setInt(1, id);
        row = preparedStatement.executeUpdate();
        return row > 0;
    }

    @Override
    public List<User> findUser(String country) {
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement=baseRepo.getConnection().prepareStatement(FIND_USER_BY_COUNTRY_SQL);
            preparedStatement.setString(1,country);
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
    public List<User> sortName(){
        List<User> users = new ArrayList<>();
        try (PreparedStatement preparedStatement = this.baseRepo.getConnection().prepareStatement(SELECT_ALL_USERS_SORT);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id,name,email,country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    private void printSQLException(SQLException ex) {
        for(Throwable e: ex){
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
