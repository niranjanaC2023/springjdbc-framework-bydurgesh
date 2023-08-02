package com.nt.niranjana.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nt.niranjana.spring.jdbc.entity.Student;

public class CustomRowMapperImpl implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Student student = new Student();
		student.setId(rs.getInt(1));
		student.setCity(rs.getString(2));
		student.setName(rs.getString(3));
		return student;
	}

}
