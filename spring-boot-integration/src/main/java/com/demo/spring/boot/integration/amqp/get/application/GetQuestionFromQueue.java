package com.demo.spring.boot.integration.amqp.get.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.demo.spring.boot.integration.amqp.get")
public class GetQuestionFromQueue {

	public static void main(String[] args) {
		SpringApplication.run(GetQuestionFromQueue.class, args);
		// System.exit(0);
	}
}
