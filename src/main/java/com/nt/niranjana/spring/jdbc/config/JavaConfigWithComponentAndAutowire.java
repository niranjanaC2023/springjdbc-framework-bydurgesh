package com.nt.niranjana.spring.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.nt.niranjana.spring.jdbc.dao"})
public class JavaConfigWithComponentAndAutowire 
{
	@Bean("ds")
	public DriverManagerDataSource  getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/projecteidiko");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean("jdbctemplate")
	public JdbcTemplate getJdbcTemplate()
	{
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}

}
