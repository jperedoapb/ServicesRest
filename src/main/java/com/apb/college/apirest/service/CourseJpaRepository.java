/**
 * 
 */
package com.apb.college.apirest.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apb.college.apirest.entity.Course;

/**
 * @author Jaime Peredo B.
 *
 */
public interface CourseJpaRepository extends JpaRepository<Course, Serializable>{

}
