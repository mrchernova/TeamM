package by.trucking.service;

import by.trucking.model.Order;
import by.trucking.repository.OrderRepository;

import java.sql.SQLException;
import java.util.List;


public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderServiceImpl() {

    }

    @Override
    public Order getById(int id) throws SQLException {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    @Override
    public List<Order> getByCargo(String cargo) {
        return orderRepository.getByCargo(cargo);
    }

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
}



