package model.repository.user;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepo {
    boolean insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> findUser(String name);
    int getIdAuto();
}
