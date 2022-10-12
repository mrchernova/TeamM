package by.trucking.controller;

import by.trucking.model.Client;
import by.trucking.repository.ClientRepositoryDBImpl;
import by.trucking.service.ClientService;
import by.trucking.service.ClientServiceImpl;
import by.trucking.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/clients")
public class ClientController extends HttpServlet {

    private final ClientService cs = new ClientServiceImpl(
            new ClientRepositoryDBImpl(), new UserServiceImpl());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Client> clients = cs.getClients();

        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            for (int i = 0; i < clients.size(); i++) {
                writer.println(clients.get(i).getId());
                writer.println(clients.get(i).getContact());
                writer.println(clients.get(i).getTitle());
                writer.write("</br>");
            }

        } finally {
            writer.close();
        }
        writer.flush();
    }
}

