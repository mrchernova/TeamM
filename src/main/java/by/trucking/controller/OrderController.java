package by.trucking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.trucking.dao.OrderDao;
import by.trucking.model.Order;

public class OrderController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "../../order.jsp";
    private static String LIST_ORDER = "../../listOrders.jsp";
    private OrderDao dao;

    public OrderController() {
        super();
        dao = new OrderDao();
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            dao.deleteOrder(orderId);
            forward = LIST_ORDER;
            request.setAttribute("orders", dao.getAllOrders());
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            Order order = dao.getOrderById(orderId);
            request.setAttribute("order", order);
        } else if (action.equalsIgnoreCase("listOrder")){
            forward = LIST_ORDER;
            request.setAttribute("Orders", dao.getAllOrders());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();
        order.setCargo(request.getParameter("cargo"));
        //order.setWeight(request.getParameter("weight"));

        order.setDeparture(request.getParameter("departure"));
        order.setDestination(request.getParameter("destination"));
        String orderid = request.getParameter("orderid");
        if(orderid == null || orderid.isEmpty())
        {
            dao.addOrder(order);
        }
        else
        {
            order.setId(Integer.parseInt(orderid));
            dao.updateOrder(order);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_ORDER);
        request.setAttribute("orders", dao.getAllOrders());
        view.forward(request, response);
    }
}