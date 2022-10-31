package by.trucking.controller;

import by.trucking.model.Role;
import by.trucking.model.User;
import by.trucking.repository.UserRepositoryDBImpl;
import by.trucking.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/registration")
public class Registration extends HttpServlet {

    private final UserService us = new UserServiceImpl(new UserRepositoryDBImpl());


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            Role role = Role.valueOf(request.getParameter("role"));

            User user = new User(login, password, role);

            // заносит пользователя в БД, если у него уникальный логин
            if (us.checkLogin(user)) {
                PrintWriter out = response.getWriter();
                out.print("Такой логин уже существует");
                out.print("<p><a href='http://localhost:8080/registration'>Придумать новый логин</a></p>");
                out.close();
            } else {
                us.save(user);
                //response.sendRedirect(request.getContextPath() + "/verifiedUser");
                PrintWriter out = response.getWriter();
                out.print("<p>Вы успешно зарегистрировались</p>");
                out.print("<p><a href='http://localhost:8080/verifiedUser'>Получить список всех пользователей</a></p>");

                out.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/registration.jsp").forward(request, response);
        }
    }


}