package com.mvc.model;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Component("model")
@Table(name="Student")
@Data
public class Student {
     @Column(name="Roll_No") 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer rollno;
     @Column(name="Name")
     private String name;
     @Column(name="Department")
     private String dept;
}
