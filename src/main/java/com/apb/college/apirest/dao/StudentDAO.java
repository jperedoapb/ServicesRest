/**
 * 
 */
package com.apb.college.apirest.dao;

import java.util.List;

import com.apb.college.apirest.entity.Student;

/**
 * @author Jaime Peredo B.
 *
 */
public interface StudentDAO {

	public List<Student> findAll();

	public Student findById(int id);

	public void save(Student user);

	public void deleteById(int id);
}
