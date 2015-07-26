package com.demo.spring.hibernate.services.impl;

import com.demo.spring.hibernate.dao.MyClassDAO;
import com.demo.spring.hibernate.model.MyClass;
import com.demo.spring.hibernate.model.Student;
import com.demo.spring.hibernate.services.MyClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by CongDanh on 7/25/15.
 */
@Service("myClassService")
@Transactional
public class MyClassServiceImpl implements MyClassService {

    @Autowired
    private MyClassDAO myClassDAO;

    public MyClass findById(Long id, boolean lock) {
        return myClassDAO.findById(id, lock);
    }

    public List<MyClass> findAll() {
        return myClassDAO.findAll();
    }

    public List<MyClass> findByExample(MyClass exampleInstance, String... excludeProperty) {
        return myClassDAO.findByExample(exampleInstance, excludeProperty);
    }

    public MyClass makePersistent(MyClass entity) {
        return myClassDAO.makePersistent(entity);
    }

    public void makeTransient(MyClass entity) {
        myClassDAO.makeTransient(entity);
    }

    public void flush() {
        myClassDAO.flush();
    }

    public void clear() {
        myClassDAO.clear();
    }

    public MyClass getStudentsOfClass(long id) {
        return myClassDAO.getStudentsOfClass(id);
    }
}
