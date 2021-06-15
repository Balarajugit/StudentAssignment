package com.app.studentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Student;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	public IStudentService studentService;
	
	@PostMapping("/insert")
	public String insertData(@RequestBody Student student) {
		int id = studentService.insertStudent(student);
		return "student "+id+" was inserted sucessfully";
	}
	
	@GetMapping("/all")
	public List<Student> Students(){
		return studentService.getAllStudents();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		String message;
		boolean exist = studentService.isExist(id);
		if(exist) {
			studentService.deleteStudent(id);
			message="student has been deleted";
		}
		else {
			message="There is no record in database please create ";
		}
		return message;
	}
	
	@PutMapping("/update")
	public String editStudent(@RequestBody Student student) {
		String message;
		boolean exist = studentService.isExist(student.getId());
		if(exist) {
			studentService.insertStudent(student);
			message="student udated sucessfully";
		}
		else {
			message="There is no record in database please create ";
		}
		return message;
	}


}
