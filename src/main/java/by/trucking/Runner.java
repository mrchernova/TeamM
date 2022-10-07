package by.trucking;

import by.trucking.model.Client;
import by.trucking.model.Order;
import by.trucking.repository.ClientRepositoryDBImpl;
import by.trucking.repository.OrderRepositoryDBImpl;
import by.trucking.service.*;

import java.sql.SQLException;
import java.util.List;


public class Runner {
    public static void main(String[] args) throws SQLException {

        OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl(), new ClientServiceImpl());
        ClientService cs = new ClientServiceImpl(new ClientRepositoryDBImpl(), new UserServiceImpl());

        List<Order> orders = os.getOrders();

        for (int i = 0; i < orders.size(); i++) {
            System.out.println(orders.get(i).getId());
            System.out.println(orders.get(i).getCargo());
            System.out.println(orders.get(i).getWeight());
            System.out.println(orders.get(i).getDeparture());
            System.out.println(orders.get(i).getDestination());
            System.out.println(cs.getById(orders.get(i).getClient().getId()).getTitle());
            System.out.println(orders.get(i).getStatus());
            System.out.println();
        }

    }
}
