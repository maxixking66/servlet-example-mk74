package com.maktabsharif74.servlet.service;

import com.maktabsharif74.servlet.base.service.BaseService;
import com.maktabsharif74.servlet.domain.User;

public interface UserService extends BaseService<User, Long> {

    boolean existsByUsername(String username);

    User findByUsername(String username);
}
