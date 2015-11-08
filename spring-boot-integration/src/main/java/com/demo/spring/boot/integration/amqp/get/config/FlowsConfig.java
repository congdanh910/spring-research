package com.demo.spring.boot.integration.amqp.get.config;

import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.amqp.Amqp;
import org.springframework.integration.dsl.support.Transformers;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class FlowsConfig {

	@Autowired
	private RabbitMQConfig mqConfig;

	@Bean
	public SimpleMessageListenerContainer simpleMessageListenerContainer() {
		SimpleMessageListenerContainer listenerContainer = new SimpleMessageListenerContainer();
		listenerContainer.setConnectionFactory(mqConfig.connectionFactory());
		listenerContainer.setQueues(mqConfig.fanoutQueue());
		listenerContainer.setConcurrentConsumers(1);
		listenerContainer.setExclusive(true);
		return listenerContainer;
	}
	
	@Bean
	 public DirectChannel requestChannel() {
	  return new DirectChannel();
	 }

	@Bean
	public IntegrationFlow getQuestionFlow() {
		return IntegrationFlows.from(
				Amqp.inboundAdapter(simpleMessageListenerContainer()))
				.transform(Transformers.objectToString())
//				.handle("questionDao", "handle")
//				 .handle((m) -> {
//				 System.out.println("Hello : " + m.getPayload());
//				 })
//				.handle(new GenericHandler() {
//					@Override
//					public Object handle(Object payload, Map headers) {
//						System.out.println(payload);
//						System.out.println(headers);
//						return null;
//					}
//				})
				.channel("processQuestion")
				.get();
	}
	
	@Bean
	public IntegrationFlow processQuestionFlow() {
		return IntegrationFlows.from("processQuestion")
//				.transform(Transformers.objectToString())
				.handle("questionDao", "handle")
//				.handle((m) -> {
//					System.out.println(ToStringBuilder.reflectionToString(m));
//					 System.out.println("Hello : " + m.getPayload());
//				})
				.get();
	}

}
