package service;

import bean.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    List<User> selectAllUsers();

    boolean insertUser(User user) throws SQLException;

    User selectUser(int id);

    boolean updateUser(User user) throws SQLException;

    boolean deleteUser(int id) throws SQLException;

    List<User> findUser(String country);

    List<User> sortName();

    User getUserById(int id);

    boolean insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);

    void insertUpdateWithoutTransaction();

    void insertUpdateUseTransaction();

    List<User> selectAllUsersStore();

    boolean updateUserStore(User user);

    boolean deleteUserStore(int id);
}
