package by.trucking.controller;

import by.trucking.ProductDB;
import by.trucking.model.Client;
import by.trucking.model.Order;
import by.trucking.model.Product;
import by.trucking.model.Status;
import by.trucking.repository.ClientRepositoryDBImpl;
import by.trucking.repository.OrderRepositoryDBImpl;
import by.trucking.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//import static by.trucking.repository.OrderRepositoryDBImpl.save;

@WebServlet("/create_order")
public class CreateOrder extends HttpServlet {

    public static final OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl(), new ClientServiceImpl());
    private final ClientService cs = new ClientServiceImpl(new ClientRepositoryDBImpl(), new UserServiceImpl());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        getServletContext().getRequestDispatcher("/create_order.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        try {
            String description = request.getParameter("description");
            float weight = Float.parseFloat(request.getParameter("weight"));
            String departure = request.getParameter("departure");
            String destination = request.getParameter("destination");
            float price = Float.parseFloat(request.getParameter("price"));
//            int c_id = Integer.parseInt(request.getParameter("client_id"));
//            int s_id = Integer.parseInt(request.getParameter("status_id"));
//
//            Client client_id = new Client(c_id);
//            Status status_id = Status.getByOrdinal(s_id);

            Order order = new Order(description, weight, departure, destination, price);
            System.out.println(order + "!!!!!!!!!!!!!!!!!!!!!!!!!!!");//!!!!!!!!!!!!!!!!!!!!!!!!
            os.save(order);
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/create_order.jsp").forward(request, response);
        }
    }
}