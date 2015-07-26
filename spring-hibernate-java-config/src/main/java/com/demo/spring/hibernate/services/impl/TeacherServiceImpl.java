package com.demo.spring.hibernate.services.impl;

import com.demo.spring.hibernate.dao.TeacherDAO;
import com.demo.spring.hibernate.model.Teacher;
import com.demo.spring.hibernate.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by CongDanh on 7/25/15.
 */
@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDAO teacherDAO;

    public Teacher findById(Long id, boolean lock) {
        return teacherDAO.findById(id, lock);
    }

    public List<Teacher> findAll() {
        return teacherDAO.findAll();
    }

    public List<Teacher> findByExample(Teacher exampleInstance, String... excludeProperty) {
        return teacherDAO.findByExample(exampleInstance, excludeProperty);
    }

    public Teacher makePersistent(Teacher entity) {
        return teacherDAO.makePersistent(entity);
    }

    public void makeTransient(Teacher entity) {
        teacherDAO.makeTransient(entity);
    }

    public void flush() {
        teacherDAO.flush();
    }

    public void clear() {
        teacherDAO.clear();
    }
}
