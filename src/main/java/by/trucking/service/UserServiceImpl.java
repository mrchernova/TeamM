package by.trucking.service;

import by.trucking.model.Client;
import by.trucking.model.User;
import by.trucking.repository.ClientRepository;
import by.trucking.repository.UserRepository;
import by.trucking.utils.ConnectionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceImpl() {

    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User edit(User user) {
        return userRepository.edit(user);
    }

    @Override
    public boolean delete(int id) {
        return userRepository.delete(id);
    }

    @Override
    public User getById(int id) throws SQLException {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public List<User> getByLogin() {
        return null;
    }

    @Override
    public List<User> getByRole() {
        return null;
    }

    @Override
    public boolean checkLogin(User user) {
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT login FROM users WHERE login  = ?"
             )) {
            ps.setString(1, user.getLogin());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) { // true, if something was found. false, if nothing
                System.out.println("пользователь уже есть (userserviseimpl)"); //выводит в консоль
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean checkPassword(User user) {
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT login,password FROM users WHERE login  = ?"
             )) {
            ps.setString(1, user.getLogin());
            ResultSet rs = ps.executeQuery();
            rs.next();
            String password = rs.getString("password");

            if (user.getPassword().equals(password)) {
                System.out.println("Добро пожаловать, " + user.getLogin()); //выводит в консоль
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;


    }
}
