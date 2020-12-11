package com.bfs.authserver.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class HibernateDAO <T extends Serializable> {
    @Autowired
    public SessionFactory sessionFactory;

    protected Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }

    public T findById(final Integer id) { return (T) getCurrentSession().get(clazz, id); }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
