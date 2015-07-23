package com.demo.spring.hibernate.main;


import com.demo.spring.hibernate.config.HibernateConfiguration;
import com.demo.spring.hibernate.model.Student;
import com.demo.spring.hibernate.services.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

/**
 * Created by danh.ho on 23/07/2015.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);
//        AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
//        context.scan("com.websystique.spring");
//        context.refresh();

        // studentService
        StudentService studentService = (StudentService)context.getBean("studentService");

        // entity
        Student st = new Student("Danh Ho", "Tien Giang", "congdanh910@gmail.com", new Date());

        System.out.println(studentService.makePersistent(st));

    }
}
