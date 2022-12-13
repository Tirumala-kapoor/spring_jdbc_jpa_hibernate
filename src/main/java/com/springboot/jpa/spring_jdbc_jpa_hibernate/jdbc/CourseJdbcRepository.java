package com.springboot.jpa.spring_jdbc_jpa_hibernate.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springboot.jpa.spring_jdbc_jpa_hibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String insertQuery = """
			insert into course(id,name,author)
			values(?,?,?);
			""";
	
	private static String deleteQuery = """
			delete from course where id=?; 
			""";
	
	private static String selectQuery = """
			select * from course where id=?; 
			""";
	
	public void insert(Course course) {
		jdbcTemplate.update(insertQuery, 
				course.getId(),course.getName(),course.getAuthor());
	}
	
	public void delete(long id) {
		
		jdbcTemplate.update(deleteQuery,id);
	}
	
	public Course findById(long id) {
		return jdbcTemplate.queryForObject(selectQuery,
				new BeanPropertyRowMapper<>(Course.class),id);
	}
}
