/**
 * 
 */
package com.apb.college.apirest.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="libreta")
	private String libreta;
	
	@Column(name = "fecha_nacimiento", columnDefinition = "DATE")
	private LocalDate fechaNacimiento;
	
	@ManyToOne
	private Course course;


	public Student(int id, String nombre, String apellido, String libreta, LocalDate fechaNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.libreta = libreta;
		this.fechaNacimiento = fechaNacimiento;
	}

	public Student() {}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getLibreta() {
		return libreta;
	}

	public void setLibreta(String libreta) {
		this.libreta = libreta;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", libreta=");
		builder.append(libreta);
		builder.append(", fechaNacimiento=");
		builder.append(fechaNacimiento);
		builder.append(", course=");
		builder.append(course);
		builder.append("]");
		return builder.toString();
	}

	

	
	
	
}
