package com.maktabsharif74.servlet.base.repository.impl;

import com.maktabsharif74.servlet.base.domain.BaseEntity;
import com.maktabsharif74.servlet.base.repository.BaseRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements BaseRepository<E, ID> {

    protected final EntityManager entityManager;

    protected final Class<E> entityClass;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityClass = getEntityClass();
    }

    public abstract Class<E> getEntityClass();

    public E save(E e) {
        if (e.getId() == null) {
            entityManager.persist(e);
        } else {
            e = entityManager.merge(e);
        }
        return e;
    }

    public List<E> findAll() {
        return entityManager.createQuery("from " + entityClass.getSimpleName(), entityClass)
                .getResultList();
    }

    public E findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    public void deleteById(ID id) {
        E e = findById(id);
        entityManager.remove(e);
    }

    public long count() {
        return entityManager.createQuery("select count(e) from " + entityClass.getSimpleName() + " e", Long.class)
                .getSingleResult();
    }

    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void commitTransaction() {
        entityManager.getTransaction().commit();
    }

    public void rollbackTransaction() {
        entityManager.getTransaction().rollback();
    }
}
