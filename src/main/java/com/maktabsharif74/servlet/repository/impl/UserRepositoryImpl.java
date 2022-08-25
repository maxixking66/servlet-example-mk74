package com.maktabsharif74.servlet.repository.impl;

import com.maktabsharif74.servlet.base.repository.impl.BaseRepositoryImpl;
import com.maktabsharif74.servlet.domain.User;
import com.maktabsharif74.servlet.repository.UserRepository;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
