package by.trucking.service;

import by.trucking.model.Client;
import by.trucking.model.User;
import by.trucking.repository.ClientRepository;
import by.trucking.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserServiceImpl(){

    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User getById(int id) throws SQLException {
        return userRepository.getById(id);
    }

    @Override
    public List<User> getUsers() {
     List< User> users = userRepository.getUsers();
        return users;
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
