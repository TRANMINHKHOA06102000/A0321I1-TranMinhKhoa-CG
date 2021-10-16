package service.impl;

import bean.User;
import reponsitory.UserRepo;
import reponsitory.impl.UserRepoImpl;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepo userRepo = new UserRepoImpl();

    @Override
    public List<User> selectAllUsers() {
        return userRepo.selectAllUsers();
    }

    @Override
    public boolean insertUser(User user) throws SQLException {
        return userRepo.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userRepo.selectUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return userRepo.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return userRepo.deleteUser(id);
    }

    @Override
    public List<User> findUser(String country) {
        return userRepo.findUser(country);
    }

    @Override
    public List<User> sortName() {
        return userRepo.sortName();
    }

    @Override
    public User getUserById(int id) {
        return userRepo.getUserById(id);
    }

    @Override
    public boolean insertUserStore(User user) throws SQLException {
        return userRepo.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        userRepo.addUserTransaction(user, permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        userRepo.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        userRepo.insertUpdateUseTransaction();
    }

    @Override
    public List<User> selectAllUsersStore() {
        return userRepo.selectAllUsersStore();
    }

    @Override
    public boolean updateUserStore(User user) {
        return userRepo.updateUserStore(user);
    }

    @Override
    public boolean deleteUserStore(int id) {
        return userRepo.deleteUserStore(id);
    }
}
