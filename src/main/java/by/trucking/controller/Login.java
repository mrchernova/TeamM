package by.trucking.controller;

import by.trucking.model.User;
import by.trucking.repository.UserRepositoryDBImpl;
import by.trucking.service.UserService;
import by.trucking.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    private final UserService us = new UserServiceImpl(new UserRepositoryDBImpl());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            User user = new User(login, password);

            // проверяет есть ли такой логин в БД. Если есть, то далее проверка пароля
            if (us.checkLogin(user)) {
                //проверка пароля
                if(us.checkPassword(user)){
                    PrintWriter out = response.getWriter();
                    out.print("Добро пожаловать, " + user.getLogin());
                    out.close();
                }else {
                    PrintWriter out = response.getWriter();
                    out.print("Неверный логин или пароль");
                    out.close();
                }
            }else{
                response.sendRedirect(request.getContextPath() + "/login");
            }

        } catch (Exception e) {
            e.printStackTrace();
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
