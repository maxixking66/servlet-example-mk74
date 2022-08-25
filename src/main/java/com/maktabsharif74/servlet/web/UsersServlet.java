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
import java.util.List;

@WebServlet(name = "UsersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {

    protected final UserService userService;

    protected final String path = "/page/users.jsp";

    public UsersServlet() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        User currentUser = (User) request.getSession().getAttribute("currentUser");

        if (currentUser == null) {
            response.sendRedirect("/login");
        } else {
            List<User> users = userService.findAll();
            request.setAttribute("users", users);
            request.setAttribute("currentUser", currentUser);
            request.getRequestDispatcher(path).forward(request, response);
        }


    }

}
