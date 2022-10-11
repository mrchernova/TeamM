package by.trucking.service;

import by.trucking.model.Order;
import by.trucking.repository.OrderRepository;

import java.sql.SQLException;
import java.util.List;


public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;
    ClientService clientService;

    public OrderServiceImpl(OrderRepository orderRepository, ClientService clientService) {

        this.orderRepository = orderRepository;
        this.clientService = clientService;
    }

    public OrderServiceImpl() {

    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
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
        List<Order> orders = orderRepository.getOrders();
        //   orders.forEach(order -> order.setClient(clientService.getById(order.getClient().getId())));
        return orders;
    }

    @Override
    public Order getById(int id) throws SQLException {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getByDescription(String description) {
        return orderRepository.getByDescription(description);
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



