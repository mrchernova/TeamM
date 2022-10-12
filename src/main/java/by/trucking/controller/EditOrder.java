package by.trucking.controller;

import by.trucking.model.Order;
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


@WebServlet("/edit_order")
public class EditOrder extends HttpServlet {

    public static final OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl(), new ClientServiceImpl());
    private final ClientService cs = new ClientServiceImpl(new ClientRepositoryDBImpl(), new UserServiceImpl());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Order order = os.getById(id);
            if (order != null) {
                request.setAttribute("order", order);
                getServletContext().getRequestDispatcher("/edit_order.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String description = request.getParameter("description");
            float weight = Float.parseFloat(request.getParameter("weight"));
            String departure = request.getParameter("departure");
            String destination = request.getParameter("destination");
            float price = Float.parseFloat(request.getParameter("price"));
            Status status = Status.valueOf(request.getParameter("status"));

            Order order = new Order(id, description, weight, departure, destination, price, status);
            os.edit(order);

            response.sendRedirect(request.getContextPath() + "/index");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}