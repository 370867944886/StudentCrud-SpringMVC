package com.mvc.service;

import java.util.List;

import com.mvc.model.Student;

public interface IService {
	
	public String studentEnrol(Student st) throws Exception;
	
	public Iterable<Student> getAllData();
	
	public String deleteById(Integer id);
	
	public Student findById(Integer id);
	
	public String update(Student st);

}
