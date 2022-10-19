package by.trucking.service;

import by.trucking.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserService {
    User save(User user);

    User edit(User user);

    boolean delete(int id);

    User getById(int id) throws SQLException;

    List<User> getUsers();

    List<User> getByLogin();

    List<User> getByRole();

    boolean checkLogin(User user);
    boolean checkPassword(User user);
}
