package com.springboot.jpa.spring_jdbc_jpa_hibernate.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.spring_jdbc_jpa_hibernate.course.Course;

@Repository
public interface CourseSpringDatajpaRepository extends JpaRepository<Course, Long>{
	
	List<Course> findByName(String name);
	
	List<Course> findByAuthor(String author);
}
