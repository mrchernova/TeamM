package by.trucking.controller;

import by.trucking.ProductDB;
import by.trucking.repository.OrderRepositoryDBImpl;
import by.trucking.service.ClientServiceImpl;
import by.trucking.service.OrderService;
import by.trucking.service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete_order")
public class DeleteOrder extends HttpServlet {

    public static final OrderService os = new OrderServiceImpl(new OrderRepositoryDBImpl(), new ClientServiceImpl());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            os.delete(id);
            System.out.println("delete?" + os.delete(id));
            response.sendRedirect(request.getContextPath() + "/index");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}