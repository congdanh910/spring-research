package com.demo.spring.hibernate.dao.impl;

import com.demo.spring.hibernate.dao.GenericDAO;
import com.demo.spring.hibernate.dao.StudentDAO;
import com.demo.spring.hibernate.model.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by danh.ho on 23/07/2015.
 */
@Repository("studentDAO")
public class StudentDAOImpl extends GenericDAOImpl<Student, Long> implements StudentDAO {

    @Autowired
    public StudentDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
