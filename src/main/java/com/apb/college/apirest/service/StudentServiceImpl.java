/**
 * 
 */
package com.apb.college.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apb.college.apirest.dao.StudentDAO;
import com.apb.college.apirest.entity.Student;

/**
 * @author Jaime Peredo B.
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO userDAO;
	
	@Override
	public List<Student> findAll() {
		List<Student> listUsers= userDAO.findAll();
		return listUsers;
	}

	@Override
	public Student findById(int id) {
		Student user = userDAO.findById(id);
		return user;
	}

	@Override
	public void save(Student user) {
		userDAO.save(user);

	}

	@Override
	public void deleteById(int id) {
		userDAO.deleteById(id);
	}
}
