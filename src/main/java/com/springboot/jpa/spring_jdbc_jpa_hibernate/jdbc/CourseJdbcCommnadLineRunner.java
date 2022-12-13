package com.springboot.jpa.spring_jdbc_jpa_hibernate.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.jpa.spring_jdbc_jpa_hibernate.course.Course;
import com.springboot.jpa.spring_jdbc_jpa_hibernate.springdatajpa.CourseSpringDatajpaRepository;

@Component
public class CourseJdbcCommnadLineRunner implements CommandLineRunner
{

	/*
	 * @Autowired private CourseJdbcRepository repository;
	 * 
	 * @Override public void run(String... args) throws Exception {
	 * 
	 * repository.insert(new Course(1,"J2EE","Harshul"));
	 *  repository.insert(new Course(2,"Spring Jdbc","Nayan")); 
	 *  repository.insert(new Course(3,"Spring boot","Amit")); 
	 *  repository.insert(new Course(4,"Microservices","Tiru"));
	 * 
	 * repository.delete(4);
	 * 
	 * System.out.println(repository.findById(3));
	 * System.out.println(repository.findById(2));
	 * 
	 * }
	 */

	@Autowired
	private CourseSpringDatajpaRepository repository;

	@Override 
	public void run(String... args) throws Exception {
		repository.save(new Course(1,"J2EE","Harshul"));
		repository.save(new Course(2,"Spring Jdbc","Nayan"));
		repository.save(new Course(3,"Spring boot","Amit"));
		repository.save(new Course(4,"Microservices","Tiru"));
		
		//repository.deleteById(1l);
		
		List<Course> courseList = repository.findAll();
		for(Course course : courseList) {
			System.out.println(course);
		}
		System.out.println(repository.findByAuthor("Nayan"));
		System.out.println(repository.findByName("J2EE"));
		
	}
	
	

}
