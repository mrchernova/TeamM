package by.trucking.service;

import by.trucking.model.Client;
import by.trucking.model.User;
import by.trucking.repository.ClientRepository;
import by.trucking.repository.UserRepository;

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
}
