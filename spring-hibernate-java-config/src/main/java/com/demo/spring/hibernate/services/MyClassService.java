package com.demo.spring.hibernate.services;

import com.demo.spring.hibernate.model.MyClass;

/**
 * Created by CongDanh on 7/25/15.
 */
public interface MyClassService extends GenericService<MyClass, Long> {
    public MyClass getClassWithStudents(long id);
}
