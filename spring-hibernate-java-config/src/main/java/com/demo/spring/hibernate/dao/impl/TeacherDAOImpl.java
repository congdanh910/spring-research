package com.demo.spring.hibernate.dao.impl;

import com.demo.spring.hibernate.dao.TeacherDAO;
import com.demo.spring.hibernate.model.Teacher;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by CongDanh on 7/25/15.
 */
@Repository("teacherDAO")
public class TeacherDAOImpl extends GenericDAOImpl<Teacher, Long> implements TeacherDAO {

    @Autowired
    public TeacherDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
