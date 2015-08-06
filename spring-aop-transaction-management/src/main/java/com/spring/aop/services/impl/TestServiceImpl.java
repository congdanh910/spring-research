package com.spring.aop.services.impl;

import com.spring.aop.dao.TestDAO;
import com.spring.aop.exception.TestException;
import com.spring.aop.model.Test;
import com.spring.aop.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("testService")
@Transactional
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDAO testDAO;

    @Override
    public Test findById(Integer id, boolean lock) {
        return testDAO.findById(id, lock);
    }

    @Override
    public List<Test> findAll() {
        return testDAO.findAll();
    }

    @Override
    public List<Test> findByExample(Test exampleInstance,
                                    String... excludeProperty) {
        return testDAO.findByExample(exampleInstance, excludeProperty);
    }

    @Override
    public Test makePersistent(Test entity) {
        return testDAO.makePersistent(entity);
    }

    @Override
    public void makeTransient(Test entity) {
        testDAO.makePersistent(entity);
    }

    @Override
    public void flush() {
        testDAO.flush();
    }

    @Override
    public void clear() {
        testDAO.clear();
    }

    @Override
    @Transactional(rollbackFor = TestException.class)
    public void testAop(Test test, boolean exception) throws TestException {
        testDAO.testAop(test, exception);
    }
}
