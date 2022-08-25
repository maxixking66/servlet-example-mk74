package com.maktabsharif74.servlet.service.impl;

import com.maktabsharif74.servlet.base.service.impl.BaseServiceImpl;
import com.maktabsharif74.servlet.domain.User;
import com.maktabsharif74.servlet.repository.UserRepository;
import com.maktabsharif74.servlet.service.UserService;

import javax.persistence.NoResultException;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        try {
            return repository.findByUsername(username);
        } catch (NoResultException e) {
            return null;
        }
    }
}
