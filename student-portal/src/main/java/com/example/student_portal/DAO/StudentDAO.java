package com.example.student_portal.DAO;

import java.util.List;

import com.example.student_portal.entity.Student;

public interface StudentDAO {
	void save(Student theStudent);
	Student findById(Integer id);
	List <Student> findAll();
	List <Student> findByLastName(String lastname);
	void deleteById(Integer id);
	
}
