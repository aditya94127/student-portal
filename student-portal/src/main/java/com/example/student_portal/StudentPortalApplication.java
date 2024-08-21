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
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO) {
		// TODO Auto-generated method stub
		Student tempStudent=new Student("Aditya","Mishra","adi@gmail.com");
		studentDAO.save(tempStudent);
	}
	
	
	
	
}
