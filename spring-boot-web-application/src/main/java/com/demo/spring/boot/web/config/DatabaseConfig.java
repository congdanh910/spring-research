package com.demo.spring.boot.web.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

	@Value("${db.driver}")
	private String dbDriver;
	@Value("${db.url}")
	private String dbUrl;
	@Value("${db.username}")
	private String dbUsername;
	@Value("${db.password}")
	private String dbPassword;
	@Value("${hibernate.dialect}")
	private String hDialect;
	@Value("${hibernate.show_sql}")
	private String hShowSql;
	@Value("${hibernate.format_sql}")
	private String hFormatSql;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hAuto;
	@Value("${hibernate.connection.characterEncoding}")
	private String hEncoding;
	@Value("${hibernate.max_fetch_depth}")
	private String hMaxFetchDepth;
	@Value("${hibernate.package}")
	private String packagesToScan;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(dbDriver);
		driverManagerDataSource.setUrl(dbUrl);
		driverManagerDataSource.setUsername(dbUsername);
		driverManagerDataSource.setPassword(dbPassword);
		return driverManagerDataSource;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(packagesToScan);

		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.dialect", hDialect);
		hibernateProperties.put("hibernate.show_sql", hShowSql);
		hibernateProperties.put("hibernate.format_sql", hFormatSql);
		hibernateProperties.put("hibernate.hbm2ddl.auto", hAuto);
		hibernateProperties.put("hibernate.connection.characterEncoding", hEncoding);
		hibernateProperties.put("hibernate.max_fetch_depth", hMaxFetchDepth);

		sessionFactoryBean.setHibernateProperties(hibernateProperties);
		return sessionFactoryBean;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

}
