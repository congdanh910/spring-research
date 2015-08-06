package com.spring.aop.services.impl;

import com.spring.aop.dao.TestDAO;
import com.spring.aop.exception.TestException;
import com.spring.aop.model.Test;
import com.spring.aop.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
    There are 7 types of propagation supported by Spring :
        PROPAGATION_REQUIRED – Support a current transaction; create a new one if none exists.
        PROPAGATION_SUPPORTS – Support a current transaction; execute non-transactionally if none exists.
        PROPAGATION_MANDATORY – Support a current transaction; throw an exception if no current transaction exists.
        PROPAGATION_REQUIRES_NEW – Create a new transaction, suspending the current transaction if one exists.
        PROPAGATION_NOT_SUPPORTED – Do not support a current transaction; rather always execute non-transactionally.
        PROPAGATION_NEVER – Do not support a current transaction; throw an exception if a current transaction exists.
        PROPAGATION_NESTED – Execute within a nested transaction if a current transaction exists, behave like PROPAGATION_REQUIRED else.
    In most cases, you may just need to use the PROPAGATION_REQUIRED.
 */

@Service("testService")
@Transactional(propagation = Propagation.REQUIRED)
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
    @Transactional(rollbackFor = {TestException.class, Exception.class})
    public void testAop(Test test, boolean exception) throws TestException {
        testDAO.testAop(test, exception);
    }
}
