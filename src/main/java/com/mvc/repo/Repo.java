package com.mvc.repo;

import org.springframework.data.repository.CrudRepository;

import com.mvc.model.Student;

public interface Repo extends CrudRepository<Student, Integer> {

}
