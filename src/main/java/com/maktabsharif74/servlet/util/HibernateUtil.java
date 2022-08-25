package com.maktabsharif74.servlet.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");

    private HibernateUtil() {
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
