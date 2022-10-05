package by.trucking;

import by.trucking.repository.OrderRepositoryDBImpl;
import by.trucking.service.ClientServiceImpl;
import by.trucking.service.OrderService;
import by.trucking.service.OrderServiceImpl;

import java.sql.SQLException;


public class Runner {
    public static void main(String[] args) throws SQLException {

        OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl(), new ClientServiceImpl());
        //System.out.println(os.getById(2));
      //  System.out.println(os.getOrders());

    }

}
