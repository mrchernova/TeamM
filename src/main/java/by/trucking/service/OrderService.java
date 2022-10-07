package by.trucking.service;

import by.trucking.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    Order save(Order order);

    Order edit(Order order);

    boolean delete(int id);

    Order getById(int id) throws SQLException;


    List<Order> getOrders();

    List<Order> getByCargo(String cargo);

    List<Order> getByWeight(String weight);

    List<Order> getByDeparture(String daparture);

    List<Order> getByDestination(String destination);
}
