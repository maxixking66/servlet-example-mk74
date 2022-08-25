package com.maktabsharif74.servlet.repository;

import com.maktabsharif74.servlet.base.repository.BaseRepository;
import com.maktabsharif74.servlet.domain.User;

public interface UserRepository extends BaseRepository<User, Long> {
    boolean existsByUsername(String username);

    User findByUsername(String username);
}
