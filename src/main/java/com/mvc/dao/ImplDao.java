package com.mvc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.mvc.model.Student;
import com.mvc.repo.Repo;

@Repository
public class ImplDao implements IDao {
	@Autowired
	private Repo repo;

	@Override
	public Student enroll(Student st) {

	    Student stu = null;

	    try {
	        stu = repo.save(st);
	    }
	    catch (DataIntegrityViolationException e) {
	        System.out.println("Data integrity violation: " + e.getMessage());
	    }
	    catch (DataAccessException e) {
	        System.out.println("Database operation failed: " + e.getMessage());
	    }

	    return stu;
	}

	@Override
	public Iterable<Student> getALlData() {
		
		Iterable<Student> st=null;
		try
		{
		   st=repo.findAll();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public String deleteById(Integer id) {
		
		Optional<Student> st=repo.findById(id);
		if(st.get()!=null)
		{
			repo.deleteById(id);
			return "deleted successfuly as id:"+id;
		}
		else		
		return "record not found";
	}

	@Override
	public Optional<Student> findById(Integer id) {
		
		Optional<Student> st=repo.findById(id);
		if (st.isEmpty()) {
	        throw new RuntimeException("Student not found with ID: " + id);
	    }

	    return st;
		
	}

	@Override
	public Student update(Student st) {
		
		Student s=repo.save(st);
		return s;
	}

}
