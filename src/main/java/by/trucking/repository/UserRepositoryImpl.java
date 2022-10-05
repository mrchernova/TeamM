package by.trucking.repository;

import by.trucking.model.Role;
import by.trucking.model.User;
import by.trucking.utils.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User edit(User user) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

//    @Override
//    public User getById(int id) throws SQLException {
//        return null;
//    }

    @Override
    public User getById(int id) throws SQLException {

        try (PreparedStatement ps = ConnectionDB.getConnect().prepareStatement("SELECT * FROM users WHERE id=?");) {
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
        return null;
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
