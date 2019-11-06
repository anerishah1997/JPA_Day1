package com.lti.ui;

import java.util.Scanner;

import com.lti.model.Student;
import com.lti.service.StudentService;
import com.lti.service.StudentServiceImpl;

public class MainFinal {

private static StudentService studentService = null;
	
	static{
		studentService = new StudentServiceImpl();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans,name;
		int no;
		double avgScore=0.0;
		int rollno = 0;
		Student student = null;
		do {
			
			System.out.println("1.Add Student ");
			System.out.println("2.Read Student By Roll Number ");
			System.out.println("3.Modify Student");
			System.out.println("4.Delete Student");
			System.out.println("Pls enter your choice: ");
			
			no = sc.nextInt();
			switch (no) {
			case 1:	System.out.println("Enter Roll_Number: ");
			        rollno = sc.nextInt();
			        System.out.println("Enter Name: ");
			        name = sc.next();
			        System.out.println("Enter avgScore: ");
			        avgScore = sc.nextDouble();
			        student = new Student(rollno, name, avgScore);
			        boolean result = studentService.addStudent(student);
					if(result)
						System.out.println("Student added successfully in dB");
					break;
					
			case 2: System.out.println("Enter the rollnumber of student you wanna find: ");
			 		rollno = sc.nextInt();
			        student = studentService.findStudentByRollNumber(rollno);
			        System.out.println(student);
					break;
					
			case 3: System.out.println("Enter the rollnumber of student you want to modify: ");
					rollno = sc.nextInt();
			        student = studentService.findStudentByRollNumber(rollno);
			        System.out.println(student);
			        System.out.println("Modify Name: ");
			        name = sc.next();
			        System.out.println("Modify AvgScore: ");
			        avgScore = sc.nextDouble();
			        student = new Student(rollno, name, avgScore);
			        Student stud1 = studentService.modifyStudent(student);
			        System.out.println(stud1);
					break;
			case 4: System.out.println("Enter the roll number you wanna delete");
			        rollno = sc.nextInt();
			        boolean result1 = studentService.removeStudent(rollno);
					if(result1)
						System.out.println("Student removed successfully from dB");
		    default: System.out.println("Wrong choice entered");
			        
			}
			System.out.println("Do you want to continue yes/no");
			ans = sc.next();
		} while (ans.equals("Yes") || ans.equals("y") || ans.equals("yes")||ans.equals("YES"));

	}

}
