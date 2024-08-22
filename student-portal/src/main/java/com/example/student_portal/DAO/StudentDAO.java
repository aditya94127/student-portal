package com.example.student_portal.DAO;

import com.example.student_portal.entity.Student;

public interface StudentDAO {
	void save(Student theStudent);
	Student findById(Integer id);
}
