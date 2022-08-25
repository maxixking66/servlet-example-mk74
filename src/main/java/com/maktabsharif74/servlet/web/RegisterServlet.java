package com.maktabsharif74.servlet.web;

import com.maktabsharif74.servlet.domain.User;
import com.maktabsharif74.servlet.service.UserService;
import com.maktabsharif74.servlet.util.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    private final UserService userService;

    private final String path = "/page/register.jsp";

    public RegisterServlet() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect(path);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(
                firstName, lastName, username, password
        );

        if (userService.existsByUsername(username)) {
            request.setAttribute("duplicateUsername", true);
            request.setAttribute("username", username.concat(" - 10"));
            request.setAttribute("user", user);
            request.getRequestDispatcher(path).forward(request, response);
        } else {
            userService.save(
                    user
            );
            request.setAttribute("successFullRegister", true);
            request.getRequestDispatcher("/page/login.jsp").forward(request, response);
        }

    }
}
