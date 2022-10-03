package by.trucking;

import by.trucking.model.Order;
import by.trucking.repository.OrderRepositoryDBImpl;
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

    private final OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl());

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> orders = os.getOrders();
  //      PrintWriter writer = response.getWriter();
//        try {
//            writer.println("orders: ");
//            for (int i = 0; i < orders.size(); i++) {
//                writer.println(orders.get(i));
//            }
//            writer.println();
//            writer.flush();
//        } finally {
//            writer.close();
//        }

          PrintWriter writer = response.getWriter();
          writer.write(os.getOrders().toString());
          writer.flush();
    }


}
