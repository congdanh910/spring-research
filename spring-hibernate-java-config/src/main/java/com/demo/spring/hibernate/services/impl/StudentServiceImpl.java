package com.demo.spring.hibernate.services.impl;

import com.demo.spring.hibernate.dao.StudentDAO;
import com.demo.spring.hibernate.model.Student;
import com.demo.spring.hibernate.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by danh.ho on 23/07/2015.
 */
@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;


    public Student findById(Long id, boolean lock) {
        return studentDAO.findById(id, lock);
    }

    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    public List<Student> findByExample(Student exampleInstance, String... excludeProperty) {
        return studentDAO.findByExample(exampleInstance, excludeProperty);
    }

    public Student makePersistent(Student entity) {
        return studentDAO.makePersistent(entity);
    }

    public void makeTransient(Student entity) {
        studentDAO.makeTransient(entity);

    }

    public void flush() {
        studentDAO.flush();
    }

    public void clear() {
        studentDAO.flush();

    }
}
