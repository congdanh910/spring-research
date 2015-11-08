package com.demo.spring.boot.integration.amqp.push.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:rabbitmq.properties")
public class RabbitMQConfig {

	@Value("${rabbitmq.addresses}")
	private String addresses;

	@Value("${rabbitmq.username}")
	private String username;

	@Value("${rabbitmq.password}")
	private String password;

	@Value("${rabbitmq.fanout.exchange}")
	private String exchange;

	@Value("${rabbitmq.fanout.routing.key}")
	private String fanoutRoutingKey;

	@Value("${rabbitmq.fanout.queue}")
	private String fanoutQueue;

	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(addresses);
		connectionFactory.setUsername(username);
		connectionFactory.setPassword(password);
		return connectionFactory;
	}

	@Bean(name = "fanoutTemplate")
	public RabbitTemplate fanoutTemplate() {
		RabbitTemplate fanoutTemplate = new RabbitTemplate();
		fanoutTemplate.setExchange(exchange);
		fanoutTemplate.setRoutingKey(fanoutRoutingKey);
		fanoutTemplate.setConnectionFactory(connectionFactory());
		return fanoutTemplate;
	}

	@Bean(name = "fanoutQueue")
	public Queue fanoutQueue() {
		return new Queue(fanoutQueue);
	}
}
