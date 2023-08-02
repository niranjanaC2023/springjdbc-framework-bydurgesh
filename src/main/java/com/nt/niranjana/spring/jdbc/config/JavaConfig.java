package com.nt.niranjana.spring.jdbc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.nt.niranjana.spring.jdbc.dao.StudentDaoImpl;

@Configuration
public class JavaConfig 
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
	
	//@Bean("studentdaoimpl")   //also work
	@Bean(name={"studentdaoimpl"})
	public StudentDaoImpl getStudentDaoImpl()
	{
		StudentDaoImpl studdaoImpl = new StudentDaoImpl();
		studdaoImpl.setJdbcTemplate(getJdbcTemplate());
		return studdaoImpl;
	}

}
