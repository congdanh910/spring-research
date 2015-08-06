package com.spring.aop.dao;

import com.spring.aop.exception.TestException;
import com.spring.aop.model.Test;

public interface TestDAO extends GenericDAO<Test, Integer> {
    public void testAop(Test test, boolean exception) throws TestException;
}
