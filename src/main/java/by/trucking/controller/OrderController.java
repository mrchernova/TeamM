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

        writer.println("<center><table border=\"1\" style=\"width:60%\" >");
        writer.println("<tr>" +
                "<th>id</th>" +
                "<th>description</th>" +
                "<th>weight</th>" +
                "<th>departure</th>" +
                "<th>destination</th>" +
                "<th>price</th>" +
                "<th>client_id</th>" +
                "<th>status_id</th>" +
                "</tr>");

        try {
            for (int i = 0; i < orders.size(); i++) {

                writer.println("<tr><td>" + orders.get(i).getId() + "</td>");
                writer.println("<td>" + orders.get(i).getDescription()+"</td>");
                writer.println("<td>" + orders.get(i).getWeight() + "</td>");
                writer.println("<td>" + orders.get(i).getDeparture() + "</td>");
                writer.println("<td>" + orders.get(i).getDestination() + "</td>");
                writer.println("<td>" + orders.get(i).getPrice() + "</td>");
                writer.println("<td>" + cs.getById(orders.get(i).getClient().getId()).getTitle() + "</td>");
                writer.println("<td>" + orders.get(i).getStatus() + "</td></tr>");
                writer.write("</br>");
            }
            writer.println("</table>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            writer.close();
        }
        writer.flush();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Order order = new Order();
        PrintWriter writer = response.getWriter();
        writer.println("<table border=" + 1 + "><tr><td>lalala");
        //  order.setDescription(request.getParameter("description"));
        //  order.setWeight(Float.parseFloat(request.getParameter("weight")));
        //    order.setDeparture(request.getParameter("departure"));
        //   order.setDestination(request.getParameter("destination"));
        order.setPrice(Float.parseFloat(request.getParameter("price")));
        //order.setClient(Integer.parseInt(request.getParameter("client_id")));
        //order.setStatus(Integer.parseInt(request.getParameter("status_id")));
        //order.setClient(request.setAttribute("client_id", client.getId()));
        writer.println("</td></tr></table>");
        os.save(order);

        writer.flush();

    }
}

