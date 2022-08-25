package com.maktabsharif74.servlet.web;

import com.maktabsharif74.servlet.service.UserService;
import com.maktabsharif74.servlet.util.ApplicationContext;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected final UserService userService;

    protected final String path = "/page/login.jsp";

    public LoginServlet() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect(path);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        User user = userService.findByUsername(username);
//        if (user != null && password.equals(user.getPassword())) {
//            request.getSession().setAttribute("currentUser", user);
//            request.setAttribute("currentUser", user);
//            response.sendRedirect("/users");
//        } else {
//            request.setAttribute("loginFailed", true);
//            request.getRequestDispatcher(path).forward(request, response);
//        }
//
//    }
}
