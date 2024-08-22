package com.example.student_portal.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.student_portal.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
public class StudentDAOImpl implements StudentDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Override
	@Transactional
	public void save(Student theStudent) {
		// TODO Auto-generated method stub
		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Student.class,id);
	}

}
