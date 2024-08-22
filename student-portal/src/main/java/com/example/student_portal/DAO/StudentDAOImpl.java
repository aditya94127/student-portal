package com.example.student_portal.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.EntityManagerFactoryAccessor;
import org.springframework.stereotype.Repository;

import com.example.student_portal.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("SELECT s from Student s where s.email like '%m'",Student.class).getResultList();
	}

	@Override
	public List<Student> findByLastName(String lastname) {
		// TODO Auto-generated method stub
		TypedQuery <Student> query=entityManager.createQuery("SELECT s from Student s where lastName=:theData",Student.class).setParameter("theData",lastname);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		entityManager.remove(entityManager.find(Student.class, id));
	}
		
	
	
}
