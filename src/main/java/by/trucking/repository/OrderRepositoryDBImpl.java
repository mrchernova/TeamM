package by.trucking.repository;

import by.trucking.model.Client;
import by.trucking.model.Order;
import by.trucking.model.Product;
import by.trucking.model.Status;
import by.trucking.utils.ConnectionDB;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryDBImpl implements OrderRepository {

    /**
     * Поле status_id при создании заказа будет всегда AVALIABLE
     * Поле client_id будет подставляться автоматически, так так будет известно
     */
    @Override
    public Order save(Order order) {
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO orders (description,weight,departure,destination,price,client_id,status_id) values (?,?,?,?,?,?,?)"
             )) {
            ps.setString(1, order.getDescription());
            ps.setFloat(2, order.getWeight());
            ps.setString(3, order.getDeparture());
            ps.setString(4, order.getDestination());
            ps.setFloat(5, order.getPrice());
//            ps.setInt(6, order.getClient().getId());
            ps.setInt(6, 90); // пока  client_id = 90, в дальнейшем значение будет соответствовать клиенту
            ps.setInt(7, Status.AVALIABLE.ordinal());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order edit(Order order) {
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement(
                     "UPDATE orders SET description=?, weight=?,departure=?,destination=?,price=?,status_id=? WHERE id = ?"
             )) {
            ps.setString(1, order.getDescription());
            ps.setFloat(2, order.getWeight());
            ps.setString(3, order.getDeparture());
            ps.setString(4, order.getDestination());
            ps.setFloat(5, order.getPrice());
           // ps.setInt(6, order.getStatus().ordinal());
            ps.setInt(6, order.getStatus().ordinal());

            ps.setInt(7, order.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(order.getStatus().ordinal());
            e.printStackTrace();
        }
        return order;
    }


    @Override
    public boolean delete(int id) {
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement(
                     "DELETE FROM orders WHERE id = ?"
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
        Order order = null;
        try (Connection connection = ConnectionDB.getConnect();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM orders WHERE id=?")) {
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int o_id = rs.getInt("id");
                String description = rs.getString("description");
                float weight = rs.getFloat("weight");
                String departure = rs.getString("departure");
                String destination = rs.getString("destination");
                float price = rs.getFloat("price");
                Status status = Status.getByOrdinal(rs.getInt("status_id")); //выведет AVALIABLE или типа того
              //  Status.getByOrdinal(rs.getInt(8)));
                order = new Order(o_id, description, weight, departure, destination, price, status);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return order;
    }

    @Override
    public List<Order> getByDescription(String description) {
        List<Order> orderList = new ArrayList<>();
        return orderList;
    }

    @Override
    public List<Order> getByWeight(String weight) {
        return null;
    }

    @Override
    public List<Order> getByDeparture(String departure) {
        return null;
    }

    @Override
    public List<Order> getByDestination(String destination) {
        return null;
    }

    @Override
    public List<Order> getByPrice(String price) {
        return null;
    }
}
