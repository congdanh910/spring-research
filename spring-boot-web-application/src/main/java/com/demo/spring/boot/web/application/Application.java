package com.demo.spring.boot.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by CongDanh on 10/12/15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.demo.spring.boot.web")
@PropertySource({ "classpath:application.properties" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
