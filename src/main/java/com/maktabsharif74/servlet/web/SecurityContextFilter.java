package com.maktabsharif74.servlet.web;

import com.maktabsharif74.servlet.domain.User;
import com.maktabsharif74.servlet.util.SecurityContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class SecurityContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        User currentUser = (User) httpServletRequest.getSession().getAttribute("currentUser");
        if (currentUser != null) {
            SecurityContext.setCurrentUser(currentUser);
        } else {
            SecurityContext.clear();
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
