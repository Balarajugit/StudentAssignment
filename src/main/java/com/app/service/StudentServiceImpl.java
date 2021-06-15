package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Student;
import com.app.repo.StudentRepository;
@Service
public class StudentServiceImpl implements IStudentService {
	@Autowired
	public StudentRepository studentRepo;

	@Override
	public int insertStudent(Student student) {
		int id=studentRepo.save(student).getId();
		return id;
	}
	
	@Override
	public List<Student> getAllStudents() {
		
		List<Student> all = studentRepo.findAll();
		return all;
	}
	
	@Override
	public void deleteStudent(int id) {
		studentRepo.deleteById(id);
		
	}
	
	@Override
	public boolean isExist(int id) {
		boolean existsById = studentRepo.existsById(id);
		return existsById;
	}

}
