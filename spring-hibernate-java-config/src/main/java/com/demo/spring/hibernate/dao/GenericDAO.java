package com.demo.spring.hibernate.dao;

/**
 * Created by danh.ho on 23/07/2015.
 */


import java.util.List;
import java.io.Serializable;

public interface GenericDAO<T, ID extends Serializable> {

    T findById(ID id, boolean lock);

    List<T> findAll();

    List<T> findByExample(T exampleInstance, String... excludeProperty);

    T makePersistent(T entity);

    void makeTransient(T entity);

    /**
     * Affects every managed instance in the current persistence context!
     */
    void flush();

    /**
     * Affects every managed instance in the current persistence context!
     */
    void clear();

}