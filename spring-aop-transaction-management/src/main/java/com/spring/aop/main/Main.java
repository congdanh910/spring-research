package com.spring.aop.main;

import com.spring.aop.exception.TestException;
import com.spring.aop.model.Test;
import com.spring.aop.services.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * Created by danh.ho on 06/08/2015.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop-transaction-system-servlet.xml");

        TestService testService = ctx.getBean(TestService.class);

        Test test = new Test("Danh", 28, new Date(), 20);

        try {
            testService.testAop(test, false);
        } catch (TestException e) {
            System.out.print("--------------------------------------------------");
            System.out.print(e.getMessage());
            System.out.print("--------------------------------------------------");
        }
    }
}
