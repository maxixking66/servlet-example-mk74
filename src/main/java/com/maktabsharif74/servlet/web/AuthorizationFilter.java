package com.maktabsharif74.servlet.web;

import com.maktabsharif74.servlet.util.SecurityContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String servletPath = httpServletRequest.getServletPath();

//        www.felan.com/page/login.jsp

        if ("/login".equals(servletPath) || "/register".equals(servletPath) ||
                "/page/login.jsp".equals(servletPath) || "/page/register.jsp".equals(servletPath) ||
                servletPath.contains("/assets")) {
            chain.doFilter(request, response);
        } else {
            if (SecurityContext.getCurrentUser() == null) {
                httpServletResponse.sendRedirect("/page/login.jsp");
            } else {
                chain.doFilter(request, response);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
