package com.mvc.dao;

import java.util.List;
import java.util.Optional;

import com.mvc.model.Student;

public interface IDao {

	public Student enroll(Student st);
	
	public Iterable<Student> getALlData();
	
	public String deleteById(Integer id);
	
	public Optional<Student> findById(Integer id);
	
	public Student update(Student st);
}
