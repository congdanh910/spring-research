package com.demo.spring.boot.jersey.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by CongDanh on 10/11/15.
 *
 * The case study :
 *  If we are on the root package we can use only the annotation @SpringBootApplication
 *  References (best practices) : http://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-using-springbootapplication-annotation.html
 *  The root package means that it is com.demo.spring.boot.jersey.Application
 *
 */

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.demo.spring.boot.jersey")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
