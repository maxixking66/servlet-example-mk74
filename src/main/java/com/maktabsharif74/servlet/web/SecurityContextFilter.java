package com.maktabsharif74.servlet.web;

import com.maktabsharif74.servlet.domain.User;
import com.maktabsharif74.servlet.util.SecurityContext;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;

//@WebFilter(urlPatterns = "/*")
public class SecurityContextFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//        User currentUser = (User) httpServletRequest.getSession().getAttribute("currentUser");
//        if (currentUser != null) {
//            SecurityContext.setCurrentUser(currentUser);
//        } else {
//            SecurityContext.clear();
//        }
//        chain.doFilter(request, response);

        SecurityContext.clear();

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;

        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null && cookies.length != 0) {
            Arrays.stream(cookies)
                    .filter(cookie -> "USER".equals(cookie.getName()))
                    .findAny()
                    .ifPresent(cookie -> {
                        String value = cookie.getValue();
                        String userInfo = new String(
                                Base64.getDecoder().decode(value.getBytes(StandardCharsets.UTF_8))
                        );
                        String[] split = userInfo.split(":");
                        if (split.length == 3) {
                            SecurityContext.setCurrentUser(
                                    new User(
                                            Long.valueOf(split[0]),
                                            split[1],
                                            split[2]
                                    )
                            );
                        }

                    });
        }


        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
