package com.nt.niranjana.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.niranjana.spring.jdbc.config.JavaConfig;
import com.nt.niranjana.spring.jdbc.dao.StudentDaoImpl;
import com.nt.niranjana.spring.jdbc.entity.Student;

/**
 * Hello world!
 *
 */
public class SpringJdbcTemplateConfigUsingJavaConfig 
{
	 
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
       
       ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
       
       //IStudentDao dao = context.getBean("studentdaoimpl",IStudentDao.class);       //also work
       StudentDaoImpl daoImpl = context.getBean("studentdaoimpl",StudentDaoImpl.class);
       
       //insert into student table
       
       Student student = new Student();
       student.setId(107);
       student.setCity("Mumbai");
       student.setName("Kiran");
       int totalStudentAddes =  daoImpl.insert(student);
       System.out.println("Number of Students Added: "+totalStudentAddes);
       
       
     //update into student table
       
       Student student2 = new Student();
       student2.setId(105);  //existing id
       student2.setCity("Hyderabad");
       student2.setName("Shyam");
       int totalStudentUpdated =  daoImpl.update(student2);
       System.out.println("Number of Students Updated: "+totalStudentUpdated);
       
       
     //delete from student table
       
       int totalStudentDeleted =  daoImpl.delete(101);
       System.out.println("Number of Students Deleted: "+totalStudentDeleted);
       
       
       //fetch single student object/row data from student table using studentId(using RowMapper<I> with our own impl class)
       Student singleStudentsData = daoImpl.getSingleStudentsDetails(105);
       System.out.println("singleStudentsData: "+singleStudentsData);
       
       //fetch single student object/row data from student table using studentId(Annonymous Inner class)
       Student singleStudentsDataAnno = daoImpl.getSingleStudentsDetailsUsingAnnonymous(105);
       System.out.println("singleStudentsDataAnno: "+singleStudentsDataAnno);
       
       //fetch multiple student object/all row data from student table(using RowMapper<I> with our own impl class)
       List<Student> multipleStudentsData = daoImpl.getMultipleStudentsDetails();
       System.out.println("multipleStudentsData: "+multipleStudentsData);
       
       //fetch multiple student object/all row data from student table(Annonymous Inner class)
       List<Student> multipleStudentsDataAnno = daoImpl.getMultipleStudentsDetailsUsingAnnonymous();
       System.out.println("multipleStudentsDataAnno: "+multipleStudentsDataAnno);
        
    }
}
