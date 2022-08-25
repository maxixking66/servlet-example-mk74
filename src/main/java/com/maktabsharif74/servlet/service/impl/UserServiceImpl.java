package com.maktabsharif74.servlet.service.impl;

import com.maktabsharif74.servlet.base.service.impl.BaseServiceImpl;
import com.maktabsharif74.servlet.domain.User;
import com.maktabsharif74.servlet.repository.UserRepository;
import com.maktabsharif74.servlet.service.UserService;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
