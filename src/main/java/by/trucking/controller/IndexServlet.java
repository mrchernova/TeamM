
package by.trucking.controller;

import by.trucking.model.User;
import by.trucking.repository.UserRepositoryDBImpl;
import by.trucking.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/verifiedUser")
public class IndexServlet extends HttpServlet {
    private final UserService us = new UserServiceImpl(new UserRepositoryDBImpl());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        List<User> users = us.getUsers();
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/verifiedUser.jsp").forward(request, response);


    }

}

