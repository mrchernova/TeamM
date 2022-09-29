package by.trucking.repository;

import by.trucking.model.Order;
import by.trucking.service.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryDBImpl implements OrderRepository {

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Order edit(Order order) {
        return null;
    }

    @Override
    public List<Order> getByWeight(String weight) {
        return null;
    }

    @Override
    public List<Order> getByDeparture(String daparture) {
        return null;
    }

    @Override
    public List<Order> getByDestination(String destination) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Order getById(int id) throws SQLException {
        try (PreparedStatement ps = ConnectionDB.connection.prepareStatement("SELECT * FROM orders WHERE id=?");) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    return new Order(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getFloat(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getFloat(6));
                 //   rs.getInt(7),
                 //   rs.getInt(8));
                    

                } else {
                    return new Order();
                }
            }
        }
    }

    /* getByCargo исправить*/
    @Override
    public List<Order> getByCargo(String cargo) {
        List<Order> orderList = new ArrayList<>();
        try (Statement postman = ConnectionDB.connection.createStatement();
             ResultSet rs = postman.executeQuery("SELECT * FROM orders");) {


            while (rs.next()) {
                Order o = new Order(rs.getInt("id"),
                        rs.getString("cargo"),
                        rs.getFloat("weight"),
                        rs.getString("departure"),
                        rs.getString("destination"),
                        rs.getFloat("price"));
                orderList.add(o);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

            return orderList;
        }

    }


}
