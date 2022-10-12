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


@WebServlet("/create_order")
public class CreateOrder extends HttpServlet {

    public static final OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl(), new ClientServiceImpl());

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

            Order order = new Order(description, weight, departure, destination, price);
            os.save(order);
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/create_order.jsp").forward(request, response);
        }
    }
}