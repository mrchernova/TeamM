package by.trucking.repository;

import by.trucking.model.Role;
import by.trucking.model.User;
import by.trucking.utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryDBImpl implements UserRepository {
    @Override
    public User save(User user) {
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO users (login,password,role_id) values (?,?,?)"
             )) {
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getRole().ordinal());
            ps.executeUpdate(); // проверку на одинаковые логины надо. сервис?
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User edit(User user) {
            try (Connection connection = ConnectionDB.getConnect();
                 PreparedStatement ps = connection.prepareStatement(
                         "UPDATE users SET password=? WHERE id = ?"
                 )) {
//                ps.setString(1, user.getLogin());
                ps.setString(1, user.getPassword());
//                ps.setInt(3, user.getRole().ordinal());
                ps.setInt(2, user.getId());

                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
    }

    @Override
    public boolean delete(int id) {
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement(
                     "DELETE FROM users WHERE id = ?"
             )) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }


    @Override
    public User getById(int id) throws SQLException {

        User user = null;
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id=?")) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int o_id = rs.getInt("id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                Role role = Role.getByOrdinal(rs.getInt("role_id"));
                user = new User(o_id, login, password, role);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    @Override
    public List<User> getUsers() {

        List<User> userList = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM users")) {
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

    @Override
    public boolean checkLogin(User user) {
        return false;
    }
    public boolean checkPassword(User user) {
        return false;
    }
}
