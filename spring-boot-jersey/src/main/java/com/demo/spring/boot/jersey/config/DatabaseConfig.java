package com.demo.spring.boot.jersey.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by CongDanh on 10/11/15.
 * This class is created for the purpose that is multi Datasource and JdbcTemplate
 */

@Configuration
public class DatabaseConfig {

    @Bean(name = "springBootDatasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.spring-boot")
    public DataSource springBootDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "springBootJdbcTemplate")
    @Autowired
    public JdbcTemplate springBootJdbcTemplate(@Qualifier("springBootDatasource") DataSource springBootDataSource) {
        return new JdbcTemplate(springBootDataSource);
    }

    @Bean(name = "dropwizardDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.dropwizard")
    public DataSource dropwizardDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dropwizardJdbcTemplate")
    @Autowired
    public JdbcTemplate dropwizardJdbcTemplate(@Qualifier("dropwizardDatasource") DataSource dropwizardDatasource) {
        return new JdbcTemplate(dropwizardDatasource);
    }
}
