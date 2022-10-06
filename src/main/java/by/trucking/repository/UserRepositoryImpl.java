package by.trucking.repository;

import by.trucking.model.Client;
import by.trucking.model.Role;
import by.trucking.model.Status;
import by.trucking.model.User;
import by.trucking.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
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

        try (PreparedStatement ps = ConnectionDB.getConnect().prepareStatement("SELECT * FROM users WHERE id=?")) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery();) {

                if (rs.next()) {
                    return new User(rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            Role.getByOrdinal(rs.getInt(4)));

                } else {
                    return new User();
                }
            }
        }
    }

    @Override
    public List<User> getUsers() {

        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM users)")) {
            while (rs.next()) {
                User u = new User(rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        Role.getByOrdinal(rs.getInt("role_id")));
                userList.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
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
