package com.demo.mongodb.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by danh.ho on 27/07/2015.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("mongodb-system-servlet.xml");
        System.out.println(ctx);
    }

}
