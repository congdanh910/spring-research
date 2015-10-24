package com.demo.spring.boot.web.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import com.demo.spring.boot.web.uuid.UniqueId;

@Configuration
public class BeansConfig {

	@Bean(name = "uuid")
	public UniqueId initUUIDGenerator() {
		return new UniqueId();
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
