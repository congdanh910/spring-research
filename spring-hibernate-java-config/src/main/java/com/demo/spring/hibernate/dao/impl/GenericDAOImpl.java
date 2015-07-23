package com.demo.spring.hibernate.dao.impl;

/**
 * Created by danh.ho on 23/07/2015.
 */

import com.demo.spring.hibernate.dao.GenericDAO;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private SessionFactory sessionFactory;
    private Class<T> persistentClass;

    public GenericDAOImpl(SessionFactory sessionFactory) {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.sessionFactory = sessionFactory;
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    protected Session getSession() {
        Session session = null;
        try {
            if (session == null) {
                session = getCurrentSession();
            }
        } catch (org.hibernate.HibernateException he) {
            session = getCurrentSession();
        }
        return session;
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @SuppressWarnings({"unchecked"})
    public T findById(ID id, boolean lock) {
        T entity;
        if (lock) {
            entity = (T) getSession().get(getPersistentClass(), id, LockOptions.UPGRADE);
        } else {
            entity = (T) getSession().load(getPersistentClass(), id);
        }
        return entity;
    }

    public List<T> findAll() {
        return findByCriteria();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleInstance, String... excludeProperty) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    public T makePersistent(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public void makeTransient(T entity) {
        getSession().delete(entity);
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

    /**
     * Use this inside subclasses as a convenience method.
     */
    @SuppressWarnings("unchecked")
    protected List<T> findByCriteria(Criterion... criterion) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        for (Criterion c : criterion) {
            crit.add(c);
        }
        List<T> list = crit.list();
        return list;
    }

}