
package com.apb.college.apirest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.apb.college.apirest.entity.Student;

/**
 * @author Jaime Peredo B.
 *
 */


@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Student> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
		
		List<Student> users = theQuery.getResultList();
		
		return users;

	}

	@Override
	public Student findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		Student user = currentSession.get(Student.class, id);
		
		return user;
	}

	@Override
	public void save(Student user) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(user);	
		
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);

		@SuppressWarnings("unchecked")
		Query<Student> theQuery = currentSession.createQuery("delete from User where id=:idUser");
		
		theQuery.setParameter("idUser", id);
		theQuery.executeUpdate();
		
	}

}
