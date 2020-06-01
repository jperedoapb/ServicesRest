package com.apb.college.apirest.service;

import java.util.List;

import com.apb.college.apirest.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public Student findById(int id);

	public void save(Student student);

	public void deleteById(int id);
}
