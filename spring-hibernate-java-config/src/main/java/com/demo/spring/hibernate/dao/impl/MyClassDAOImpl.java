package com.demo.spring.hibernate.dao.impl;

import com.demo.spring.hibernate.dao.MyClassDAO;
import com.demo.spring.hibernate.model.MyClass;
import com.demo.spring.hibernate.model.Student;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by CongDanh on 7/25/15.
 */
@Repository("myClassDAO")
public class MyClassDAOImpl extends GenericDAOImpl<MyClass, Long> implements MyClassDAO {

    @Autowired
    public MyClassDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public MyClass getClassWithStudents(long id) {
        MyClass myClass = (MyClass) getSession().createCriteria(MyClass.class).add(Restrictions.idEq(id)).uniqueResult();
        if (myClass != null) {
            Hibernate.initialize(myClass.getStudents());
        }
        return myClass;
    }
}
