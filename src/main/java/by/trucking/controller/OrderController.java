package by.trucking.controller;

import by.trucking.model.Client;
import by.trucking.model.Order;
import by.trucking.repository.ClientRepositoryDBImpl;
import by.trucking.repository.OrderRepositoryDBImpl;
import by.trucking.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/getorders")
public class OrderController extends HttpServlet {

    private final OrderService os = new OrderServiceImpl(
            new OrderRepositoryDBImpl(), new ClientServiceImpl());

    private final ClientService cs = new ClientServiceImpl(
            new ClientRepositoryDBImpl(), new UserServiceImpl());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Order> orders = os.getOrders();

        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            for (int i = 0; i < orders.size(); i++) {

                writer.println(orders.get(i).getId());
                writer.println(orders.get(i).getDescription());
                writer.println(orders.get(i).getWeight());
                writer.println(orders.get(i).getDeparture());
                writer.println(orders.get(i).getDestination());
                writer.println(cs.getById(orders.get(i).getClient().getId()).getTitle());
                writer.println(orders.get(i).getStatus());
                writer.write("</br>");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setAttribute("result", result);
//        request.getRequestDispatcher("/WEB-INF/result.jsp").forward(request, response);
    }
}

