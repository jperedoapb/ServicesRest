/**
 * 
 */
package com.apb.college.apirest.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apb.college.apirest.entity.Course;
import com.apb.college.apirest.entity.Student;
import com.apb.college.apirest.service.CourseService;
import com.apb.college.apirest.service.StudentService;

/**
 * @author Jaime Peredo B.
 *
 */
//Indiciamos que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
public class ProjectRestController {

	//Inyectamos el servicio para poder hacer uso de el
		@Autowired
		private StudentService userService;
		
		@Autowired
		private CourseService courseService;

		/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
		http://127.0.0.1:8080/api/users*/
		@GetMapping("/users")
		public List<Student> findAllStudent(){
			//retornará todos los usuarios
			return userService.findAll();
		}
		
		/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
		http://127.0.0.1:8080/api/users/1*/
		@GetMapping("/users/{userId}")
		public Student getUser(@PathVariable int userId){
			Student user = userService.findById(userId);
			
			if(user == null) {
				throw new RuntimeException("User id not found -"+userId);
			}
			//retornará al usuario con id pasado en la url
			return user;
		}
		
		/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
		http://127.0.0.1:8080/api/users/  */
		@PostMapping("/users")
		public Student addUser(@RequestBody Student user) {
			user.setId(0);
			/*
			 * user.getCourse().getId(); Course course =
			 * courseService.findById(user.getCourse().getId()); if(course != null) { //Este
			 * metodo guardará al usuario enviado userService.save(user); return user; }
			 * user.setApellido("ERROR de datos"); return user;
			 */
			try {
				userService.save(user);

			} catch (NoSuchElementException k) {
				throw new RuntimeException("Alumno: " + user.getApellido() + " not Found");
			}
			return user;
			
		}
		/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
		http://127.0.0.1:8080/api/users/  */
		@PutMapping("/users")
		public Student updateUser(@RequestBody Student user) {
			
			userService.save(user);
			
			//este metodo actualizará al usuario enviado
			
			return user;
		}
		
		/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del usuario
		http://127.0.0.1:8080/api/users/1  */
		@DeleteMapping("users/{userId}")
		public String deteteUser(@PathVariable int userId) {
			
			Student user = userService.findById(userId);
			
			if(user == null) {
				throw new RuntimeException("User id not found -"+userId);
			}
			
			userService.deleteById(userId);
			
			//Esto método, recibira el id de un usuario por URL y se borrará de la bd.
			return "Deleted user id - "+userId;
		}
		
		/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url 
		http://127.0.0.1:8080/api/course 
		*/
		@GetMapping("/course")
		public List<Course> findAll(){
			//retornará todos los usuarios
			return courseService.findAll();
		}
		
		/*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url + el id de un usuario
		http://127.0.0.1:8080/api/course/1
		*/
		@GetMapping("/course/{courseId}")
		public Course getCourse(@PathVariable int courseId){
			Course course = courseService.findById(courseId);
			
			if(course == null) {
				throw new RuntimeException("User id not found -"+courseId);
			}
			//retornará al usuario con id pasado en la url
			return course;
		}
		
		/*Este método se hará cuando por una petición POST (como indica la anotación) se llame a la url
		http://127.0.0.1:8080/api/course/  
		*/
		@PostMapping("/course")
		public Course addCourse(@RequestBody Course course) {
			course.setId(0);
			
			//Este metodo guardará al curso enviado
			courseService.save(course);
			
			return course;
			
		}
		
		/*Este método se hará cuando por una petición PUT (como indica la anotación) se llame a la url
		http://127.0.0.1:8080/api/course/  
		*/
		@PutMapping("/course")
		public Course updateCourse(@RequestBody Course course) {
			
			courseService.save(course);
			
			
			
			return course;
		}
		
		/*Este método se hará cuando por una petición DELETE (como indica la anotación) se llame a la url + id del curso
		http://127.0.0.1:8080/api/course/1  
		*/
		@DeleteMapping("course/{courseId}")
		public String deteteCourse(@PathVariable int courseId) {
			
			Course course = courseService.findById(courseId);
			
			if(course == null) {
				throw new RuntimeException("Couser id not found -"+ course);
			}
			
			courseService.deleteById(courseId);
			
			//Esto método, recibira el id de un usuario por URL y se borrará de la bd.
			return "Deleted user id - "+ courseId;
		}
}
