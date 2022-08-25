package com.maktabsharif74.servlet.util;

import com.maktabsharif74.servlet.repository.UserRepository;
import com.maktabsharif74.servlet.repository.impl.UserRepositoryImpl;
import com.maktabsharif74.servlet.service.UserService;
import com.maktabsharif74.servlet.service.impl.UserServiceImpl;

public class ApplicationContext {


    private static final ApplicationContext ap = new ApplicationContext();
    private UserRepository userRepository;
    private UserService userService;

    private ApplicationContext() {

    }

    public static ApplicationContext getInstance() {
        return ap;
    }

    public UserRepository getUserRepository() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl(HibernateUtil.getEntityManager());
        }
        return userRepository;
    }

    public UserService getUserService() {
        if (userService == null) {
            userService = new UserServiceImpl(getUserRepository());
        }
        return userService;
    }
}
