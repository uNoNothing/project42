package com.yeti.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

	@Value("${spring.datasource.url}")
	private String datasourceUrl;

	@Value("${spring.datasource.username}")
	private String datasourceUsername;

	@Value("${spring.datasource.password}")
	private String datasourcePassword;

	@Value("${spring.datasource.driver-class-name}")
	private String datasourceDriverClassName;
	
	public DatabaseConfig(){
		super();
	}

	@Bean
	public DataSource datasource() {
		org.apache.tomcat.jdbc.pool.DataSource datasource = new org.apache.tomcat.jdbc.pool.DataSource();
		datasource.setDriverClassName(datasourceDriverClassName);
		datasource.setUrl(datasourceUrl);
		datasource.setUsername(datasourceUsername);
		datasource.setPassword(datasourcePassword);
		return datasource;
	}

}