/**
 * 
 */
package com.apb.college.apirest.dao;

import java.util.List;

import com.apb.college.apirest.entity.User;

/**
 * @author Jaime Peredo B.
 *
 */
public interface UserDAO {

	public List<User> findAll();

	public User findById(int id);

	public void save(User user);

	public void deleteById(int id);
}
