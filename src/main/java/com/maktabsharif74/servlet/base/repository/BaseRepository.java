package com.maktabsharif74.servlet.base.repository;

import com.maktabsharif74.servlet.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<E extends BaseEntity<ID>, ID extends Serializable> {

    E save(E e);

    List<E> findAll();

    E findById(ID id);

    void deleteById(ID id);

    long count();

    void beginTransaction();

    void commitTransaction();

    void rollbackTransaction();

}
