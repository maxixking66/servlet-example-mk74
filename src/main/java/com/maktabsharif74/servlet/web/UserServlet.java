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

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    protected final UserService userService;

    protected final String path = "/page/user.jsp";

    public UserServlet() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        User currentUser = (User) request.getSession().getAttribute("currentUser");

        if (currentUser == null) {
            response.sendRedirect("/login");
        } else {
            String userId = request.getParameter("userId");

            try {
                Long id = Long.valueOf(userId);
                User user = userService.findById(id);
                request.setAttribute("user", user);
                request.getRequestDispatcher(path).forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect("/users");
            }
        }


    }

}
