package com.mvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.dao.IDao;
import com.mvc.model.Student;

@Service
public class ImplService implements IService {
      @Autowired
      private IDao dao;
	
	@Override
	public String studentEnrol(Student st) {
		
		Student stu=dao.enroll(st);
		
		if(stu !=null)
		{
			return "Student registration complete with roll no:"+stu.getRollno();
		}
		return "Failed registration";
	}

	@Override
	public Iterable<Student> getAllData() {
		
		Iterable<Student> st=dao.getALlData();
		
		return st;
	}

	@Override
	public String deleteById(Integer id) {
		
		String msg=dao.deleteById(id);
		return msg;
	}

	@Override
	public Student findById(Integer id) {
		
		Optional<Student> st=null;
		try
		{
			st=dao.findById(id);
			if (st.isEmpty()) {
		        throw new RuntimeException("Student not found with ID: " + id);
		    }
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		 Student s=st.get();
		return s;
	}

	@Override
	public String update(Student st) {
		
		Student s=dao.update(st);
		
		if(s!=null)
		{
			return s.getRollno()+"this roll updated successfuly";
		}
		else
		return "record not updated";
	}

}
