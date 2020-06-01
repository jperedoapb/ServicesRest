/**
 * 
 */
package com.apb.college.apirest.service;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apb.college.apirest.entity.Student;

/**
 * @author Jaime Peredo B.
 *
 */
public interface StudentJpaRepository extends JpaRepository <Student, Serializable>{

}
