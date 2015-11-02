package com.demo.spring.boot.jpa.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.demo.spring.boot.jpa.services.StaffService;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.demo.spring.boot.jpa")
@PropertySource({ "classpath:application.properties" })
public class MainTest {
	public static void main(String[] args) {
		SpringApplication.run(MainTest.class, args);

		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MainTest.class);
		StaffService staffService = ctx.getBean(StaffService.class);

//		 Staff staff = new Staff("Danh", "Ho", "Cong", "TG", new Timestamp(new Date().getTime()), 1000, "USD");
//		 Staff created = staffService.saveOrUpdate(staff);
//		 System.out.println("created : " + created);

//		System.out.println("Updated : " + staffService.setFirstNameForStaff(9L, "Danh Ho = " + new Date().getTime()));
		System.out.println(staffService.findByFirstName("Danh").size());
	}
}
