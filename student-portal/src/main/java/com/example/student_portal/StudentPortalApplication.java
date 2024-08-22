package com.example.student_portal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.student_portal.DAO.StudentDAO;
import com.example.student_portal.entity.Student;

@SpringBootApplication
public class StudentPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentPortalApplication.class, args);
	}
	@Bean
	public CommandLineRunner  commandLineRunner(StudentDAO studentDAO) {
		return runner ->{
//			createStudent(studentDAO);
			findStudentById(studentDAO);
		};
	}
	private void findStudentById(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		// create  a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(1);
		System.out.println(tempStudent);
		// display student
		System.out.println("Found the student: " + myStudent);
		
	}
	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		Student tempStudent=new Student("John","Ax","alex@gmail.com");
		studentDAO.save(tempStudent);
		String s1=tempStudent.toString();
		System.out.println(s1);
		
	}
	
	
	
	
}
