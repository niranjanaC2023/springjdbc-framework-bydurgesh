package com.nt.niranjana.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.niranjana.spring.jdbc.entity.Student;

public class StudentDaoImpl implements IStudentDAO
{
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() 
	{
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String toString() {
		return "StudentDaoImpl [jdbcTemplate=" + jdbcTemplate + "]";
	}

	public StudentDaoImpl() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	//insert into student table
	public int insert(Student studentDetails) 
	{
		String insertQuery = "insert into student(id,city,name)values(?,?,?)";
		 int totalDataInsert = jdbcTemplate.update(insertQuery,studentDetails.getId(),studentDetails.getCity(),studentDetails.getName());
		return totalDataInsert;
	}

	//update student table data
	public int update(Student studentData)
	{
		String updateQuery = "update student set city=?,name=? where id=?";
		 int totalDataUpdated = jdbcTemplate.update(updateQuery,studentData.getCity(),studentData.getName(),studentData.getId());
		return totalDataUpdated;
	}

	//delete single student data
	public int delete(int id) 
	{
		String deleteQuery = "delete from student where id=?";
		 int totalDataDeleted = jdbcTemplate.update(deleteQuery,id);
		return totalDataDeleted;
	}


	//fetch single object of student class using RowMapper with our own implementation class
	public Student getSingleStudentsDetails(int studentId) 
	{
		String selectQuery = "select * from student where id=?";
		RowMapper<Student> rowMapper = new CustomRowMapperImpl();
		Student singleDataOfStudent = jdbcTemplate.queryForObject(selectQuery, rowMapper,studentId);
		return singleDataOfStudent;
	}

	//fetch single object of student class using RowMapper with Annonymous Inner class, instead of creating our own impl class
	public Student getSingleStudentsDetailsUsingAnnonymous(int studentId) 
	{
		String selectQuery = "select * from student where id=?";
		Student student = jdbcTemplate.queryForObject(selectQuery, new RowMapper() {

																	public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
																	{
																		Student student = new Student();
																		student.setId(rs.getInt(1));
																		student.setCity(rs.getString(2));
																		student.setName(rs.getString(3));
																		return student;
																	}
																}, studentId);
		return student;
	}
	
	//fetch multiple object of student class using RowMapper with our own implementation class
	public List<Student> getMultipleStudentsDetails() 
	{
		String selectQuery = "select * from student";
		List<Student> multipleDataOfStudent = jdbcTemplate.query(selectQuery, new CustomRowMapperImpl());
		return multipleDataOfStudent;
	}
	
	//fetch single object of student class using RowMapper with Annonymous Inner class, instead of creating our own impl class
	public List<Student> getMultipleStudentsDetailsUsingAnnonymous() 
	{
		String selectQuery = "select * from student";
		List<Student> student = jdbcTemplate.query(selectQuery, new RowMapper() {

																	public Object mapRow(ResultSet rs, int rowNum) throws SQLException 
																	{
																		Student student = new Student();
																		student.setId(rs.getInt(1));
																		student.setCity(rs.getString(2));
																		student.setName(rs.getString(3));
																		return student;
																	}
																});
		return student;
	}

}
