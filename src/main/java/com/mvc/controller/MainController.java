package com.mvc.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.model.Student;
import com.mvc.service.ImplService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	private ImplService ser;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/report")
	public String report(Model mod)
  {
		Iterable<Student> st=ser.getAllData();
		mod.addAttribute("emplist", st);
		return "report";
		
	}
	
	@GetMapping("/registration")
	public String registration()
	{
		return "registration";
	}
	
	@PostMapping("/registration")
	public String register(@ModelAttribute("st") Student stu,Model mod,HttpSession ses)
	{
		System.out.println("data from frntend as dept:"+stu.getDept()+"name:"+stu.getName());
		
		String msg=ser.studentEnrol(stu);
		/*
		 * Iterable<Student> st=ser.getAllData(); st.forEach(list->{
		 * System.out.println(list); });
		 */
		//mod.addAttribute("emplist", st);
	     //mod.addAttribute("status", msg);	
		ses.setAttribute("status", msg);
		
		return "redirect:report";	
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("rollno") Integer rollno,HttpSession ses)
	{
		System.out.println("rollno:"+rollno);
		String msgdel=ser.deleteById(rollno);
		System.out.println("msg after deleteion"+msgdel);
		ses.setAttribute("afterdelete", msgdel);
		
		return "redirect:report";		
	}
	
	@GetMapping("/edit")
	public String modify(@RequestParam(required = false) Integer rollno, Model mod)
	{
		
		Student s=ser.findById(rollno);
		mod.addAttribute("st", s);
		
		return "update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("st") Student st,HttpSession ses)
	{
		String updatemsg=ser.update(st);
		ses.setAttribute("updatemsg", updatemsg);
		return "redirect:report";
	}
}
