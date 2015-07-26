package com.demo.spring.hibernate.dao;

import com.demo.spring.hibernate.model.MyClass;

/**
 * Created by CongDanh on 7/25/15.
 */
public interface MyClassDAO extends GenericDAO<MyClass, Long> {
    public MyClass getClassWithStudents(long id);
}
