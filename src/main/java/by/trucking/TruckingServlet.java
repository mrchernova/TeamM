package by.trucking;


import by.trucking.model.Order;
import by.trucking.repository.OrderRepositoryDBImpl;
import by.trucking.service.OrderService;
import by.trucking.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class TruckingServlet extends HttpServlet {
    private final OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl());

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println(req);
        super.service(req, res);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

           // List<Order> orders = os.getById(1);
        try {
            os.getById(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter writer = response.getWriter();
        //writer.write(orders.toString());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        String cargo = request.getParameter("cargo");


        Order order = new Order(id,cargo);
        //os.save(order);
        try {
            os.getById(2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        PrintWriter writer = response.getWriter();
        writer.write("order saved");
        writer.flush();
    }
}
