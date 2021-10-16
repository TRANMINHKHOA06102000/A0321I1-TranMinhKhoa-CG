package reponsitory;

import bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepo {
    List<User> selectAllUsers();

    boolean insertUser(User user) throws SQLException;

    User selectUser(int id);

    boolean updateUser(User user) throws SQLException;

    boolean deleteUser(int id) throws SQLException;

    List<User> findUser(String country);

    List<User> sortName();
}
