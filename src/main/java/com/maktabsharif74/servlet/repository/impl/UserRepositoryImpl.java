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

    @Override
    public boolean existsByUsername(String username) {
        return entityManager.createQuery(
                "select count(id) from User u where u.username = :username", Long.class
        ).setParameter("username", username).getSingleResult() != 0;
    }

    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery(
                "from User u where u.username = :username", User.class
        ).setParameter("username", username).getSingleResult();
    }
}
