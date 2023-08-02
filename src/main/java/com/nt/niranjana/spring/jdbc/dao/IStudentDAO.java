package com.nt.niranjana.spring.jdbc.dao;

import java.util.List;

import com.nt.niranjana.spring.jdbc.entity.Student;

public interface IStudentDAO 
{
	public int insert(Student studentDetails);
	
	public int update(Student studentData);
	
	public int delete(int id);
	
	//getting Single object from Student using its studentId(Using RowMapper<I> with our own implemented class)(querForObject()method used)
	public Student getSingleStudentsDetails(int studentId);
	
	//getting Single object from Student using its studentId(Using RowMapper<I> with Annonymous Inner class, instead of creating our own implemented class)(querForObject()method used)
	public Student getSingleStudentsDetailsUsingAnnonymous(int studentId);
	
	//getting Multiple object/all data from Student(Using RowMapper<I> with our own implemented class)(query(..)method used)
	public List<Student> getMultipleStudentsDetails();
	
	//getting multiple object/all data from Student using its studentId(Using RowMapper<I> with Annonymous Inner class, instead of creating our own implemented class)(querForObject()method used)
	public List<Student> getMultipleStudentsDetailsUsingAnnonymous();
}
