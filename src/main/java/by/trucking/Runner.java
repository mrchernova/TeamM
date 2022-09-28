package by.trucking;

import by.trucking.model.Order;
import by.trucking.model.Status;
import by.trucking.model.Transport;
import by.trucking.repository.OrderRepositoryDBImpl;
import by.trucking.service.OrderService;
import by.trucking.service.OrderServiceImpl;

import java.sql.SQLException;


public class Runner {
    public static void main(String[] args) throws SQLException {

        OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl());

    }

}
