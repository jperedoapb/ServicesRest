/**
 * 
 */
package com.apb.college.apirest.service;

import java.util.List;

import com.apb.college.apirest.entity.Course;

/**
 * @author Jaime Peredo B.
 *
 */
public interface CourseService {

	public List<Course> findAll();

	public Course findById(int id);

	public void save(Course course);

	public void deleteById(int id);
}
