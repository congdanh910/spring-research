package com.spring.aop.services;

import com.spring.aop.exception.TestException;
import com.spring.aop.model.Test;

public interface TestService extends GenericService<Test, Integer> {

    public void testAop(Test test, boolean exception) throws TestException;
}
