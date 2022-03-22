package com.spring;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentD {
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public int insertStudent(Student student)
	{
		String query="insert into student(studentId,studentName,studentGender,studentMarks,mobileNum) values(?,?,?,?,?)";
		int r=jdbcTemplate.update(query,student.getStudentId(),student.getStudentName(),student.getStudentGender(),student.getStudentMarks(),student.getMobileNum());
		return r;
	}
	public int deleteStudent(Student student)
	{
		String query1="delete from student where studentId=?";
		int r=jdbcTemplate.update(query1,student.getStudentId());
		return r;
	}
	/*public int updateStudent(Student student)
	{
		String query2="update student set studentName=? , studentMarks=? ,studentGender=?, studentMobileno=? where studentId=?";
		int r=jdbcTemplate.update(query2,student.getStudentName(),student.getStudentMarks(),student.getStudentGender(),student.getStudentMobileno(),student.getStudentId());
		return r;
	  } */	
	
	
	public List<Student> selectStudent(Student student) {
	    String query6 = "select * from student";
	    List<Student> students = jdbcTemplate.query(query6, new BeanPropertyRowMapper<Student>(Student.class));
	    return students;
	 }
}