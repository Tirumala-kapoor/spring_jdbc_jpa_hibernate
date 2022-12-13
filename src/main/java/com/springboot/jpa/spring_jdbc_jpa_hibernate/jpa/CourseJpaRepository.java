package com.springboot.jpa.spring_jdbc_jpa_hibernate.jpa;

import org.springframework.stereotype.Repository;

import com.springboot.jpa.spring_jdbc_jpa_hibernate.course.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findbyId(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById( long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
