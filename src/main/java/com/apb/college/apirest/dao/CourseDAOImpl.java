/**
 * 
 */
package com.apb.college.apirest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apb.college.apirest.entity.Course;

/**
 * @author Jaime Peredo B.
 *
 */
@Repository
public class CourseDAOImpl implements CourseDAO{

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Course> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Course> theQuery = currentSession.createQuery("from Course", Course.class);
		
		List<Course> courses = theQuery.getResultList();
		
		return courses;
		
	}

	@Override
	public Course findById(int id) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Course course = currentSession.get(Course.class,id);
		return course;
	}

	@Override
	public void save(Course course) {
Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(course);
		
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		@SuppressWarnings("unchecked")
		Query<Course> theQuery = currentSession.createQuery("delete from Course where id=:idCourse");
		theQuery.setParameter("idCourse", id);
		theQuery.executeUpdate();
		
	}

}
