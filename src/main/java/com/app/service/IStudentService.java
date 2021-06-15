package com.app.service;

import java.util.List;

import com.app.entity.Student;

public interface IStudentService {
	
	public int insertStudent(Student student);
	
	public List<Student> getAllStudents();
	
	public void deleteStudent(int id);
	
	public boolean isExist(int id);

}
