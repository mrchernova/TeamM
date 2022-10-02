package by.trucking;

import by.trucking.model.Order;
import by.trucking.service.OrderService;
import by.trucking.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GetOrdersServlet extends HttpServlet {

    private OrderService orderService;

    public GetOrdersServlet(){
        orderService = new OrderServiceImpl();

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        List<Order> orders = orderService.getOrders();

        try {
            writer.println("orders: ");
            for (int i = 0; i < orders.size() ; i++) {
                writer.println(orders.get(i));
            }

            writer.println();
        } finally {
            writer.close();
        }
    }
}
