package com.maktabsharif74.servlet.base.service.impl;

import com.maktabsharif74.servlet.base.domain.BaseEntity;
import com.maktabsharif74.servlet.base.repository.BaseRepository;
import com.maktabsharif74.servlet.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;

    protected BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        repository.beginTransaction();
        e = repository.save(e);
        repository.commitTransaction();
        return repository.save(e);
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(ID id) {
        repository.beginTransaction();

        repository.deleteById(id);

        repository.commitTransaction();

    }

    @Override
    public long count() {
        return repository.count();
    }
}
