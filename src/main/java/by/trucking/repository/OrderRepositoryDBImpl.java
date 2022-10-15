package by.trucking.repository;

import by.trucking.model.Client;
import by.trucking.model.Order;
import by.trucking.model.Status;
import by.trucking.utils.ConnectionDB;


import java.sql.*;
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
    public boolean delete(int id) {
        return false;
    }


    @Override
    public List<Order> getOrders() {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = ConnectionDB.getConnect();
             Statement statement = connection.createStatement();
           //  ResultSet rs = statement.executeQuery("SELECT * FROM orders,clients INNER JOIN clients ON orders.client_id = clients.id ")) {
             ResultSet rs = statement.executeQuery("SELECT * FROM orders")) {
            while (rs.next()) {
                Order o = new Order(rs.getInt("id"),
                        rs.getString("description"),
                        rs.getFloat("weight"),
                        rs.getString("departure"),
                        rs.getString("destination"),
                        rs.getFloat("price"),
                        new Client(rs.getInt("client_id")),
                        Status.getByOrdinal(rs.getInt("status_id")));
                orderList.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Order getById(int id) throws SQLException {
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM orders WHERE id=?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Order(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getFloat(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getFloat(6),
                            new Client(rs.getInt(7)),
                            Status.getByOrdinal(rs.getInt(8)));
                } else {
                    return new Order();
                }
            }
        }
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

}
