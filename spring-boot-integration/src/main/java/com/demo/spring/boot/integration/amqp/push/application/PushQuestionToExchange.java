package com.demo.spring.boot.integration.amqp.push.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.spring.boot.integration.amqp.model.Question;
import com.demo.spring.boot.integration.amqp.push.dao.QuestionDao;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.demo.spring.boot.integration.amqp.push")
public class PushQuestionToExchange {

	public static void main(String[] args) {
		SpringApplication.run(PushQuestionToExchange.class, args);

		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(PushQuestionToExchange.class);
		QuestionDao questionDao = ctx.getBean(QuestionDao.class);
		for (int i = 0; i < 100; i++) {
			System.out.println(questionDao.push(new Question("No." + i + " = Danh Ho", "congdanh" + i + "@gmail.com",
					"No." + i + " = Fucking question", "Hello guys, long time no see you guys!")));
		}
		System.exit(0);
	}

}
