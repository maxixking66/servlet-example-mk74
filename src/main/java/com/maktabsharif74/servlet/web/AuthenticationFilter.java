package com.maktabsharif74.servlet.web;

import com.maktabsharif74.servlet.domain.User;
import com.maktabsharif74.servlet.service.UserService;
import com.maktabsharif74.servlet.util.ApplicationContext;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

//@WebFilter(ur
// lPatterns = "/*")
public class AuthenticationFilter implements Filter {

    private final UserService userService;

    public AuthenticationFilter() {
        this.userService = ApplicationContext.getInstance().getUserService();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (httpServletRequest.getMethod().equalsIgnoreCase("post")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = userService.findByUsername(username);
            if (user != null && password.equals(user.getPassword())) {
//                httpServletRequest.getSession().setAttribute("currentUser", user);

                String userInfo = user.getId() + ":" + user.getFirstName() + ":" + user.getUsername();

                String cookieValue = Base64.getEncoder().encodeToString(userInfo.getBytes(StandardCharsets.UTF_8));

                Cookie cookie = new Cookie("USER", cookieValue);
//                cookie.setMaxAge(60 * 60 *24);
                cookie.setMaxAge((int) TimeUnit.DAYS.toSeconds(2));
                httpServletResponse.addCookie(cookie);

                httpServletResponse.sendRedirect("/users");
            } else {
                request.setAttribute("loginFailed", true);
                request.getRequestDispatcher("/page/login.jsp").forward(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
