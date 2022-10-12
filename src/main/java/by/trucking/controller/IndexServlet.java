package by.trucking.controller;

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
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    public static final OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl(), new ClientServiceImpl());
    private final ClientService cs = new ClientServiceImpl(new ClientRepositoryDBImpl(), new UserServiceImpl());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        List<Order> orders = os.getOrders();
        request.setAttribute("orders", orders);
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);


    }
}
