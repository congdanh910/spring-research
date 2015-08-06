package com.spring.aop.dao.impl;

import com.spring.aop.dao.TestDAO;
import com.spring.aop.exception.TestException;
import com.spring.aop.model.Test;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDAO")
public class TestImpl extends GenericDAOImpl<Test, Integer> implements TestDAO {

    @Autowired
    public TestImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void testAop(Test test, boolean exception) throws TestException {
        getSession().saveOrUpdate(test);
        if (exception) {
            throw new TestException("This is testing for Aop transaction management!!!");
        }
    }
}
