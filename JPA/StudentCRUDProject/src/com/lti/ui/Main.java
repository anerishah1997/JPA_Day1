package com.lti.ui;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class Main {

	private static StudentService studentService = null;
	
	static{
		studentService = new StudentServiceImpl();
	}
	
	public static void main(String[] args) {
		
		Student student = new Student(4, "Ananya", 70.5);
		
		boolean result = studentService.addStudent(student);
		if(result)
			System.out.println("Student added successfully in dB");
		
		Student student1 = studentService.findStudentByRollNumber(student.getRollNumber());
		System.out.println(student1);
		
		
		

	}

}
