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
import javax.persistence.Table;

/**
 * @author Jaime Peredo B.
 *
 */
@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	
	@Column(name = "fecha_inicio", columnDefinition = "DATE")
	private LocalDate fechaInicio;
	
	@Column(name = "fecha_fin", columnDefinition = "DATE")
	private LocalDate fechaFin;
	
	@Column(name="horas_semana")
	private String horasSemana;
	
	

	public Course() {
		
}

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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHorasSemana() {
		return horasSemana;
	}

	public void setHorasSemana(String horasSemana) {
		this.horasSemana = horasSemana;
	}

	public Course(int id, String nombre, LocalDate fechaInicio, LocalDate fechaFin, String horasSemana) {
		this.id = id;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horasSemana = horasSemana;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", fechaInicio=");
		builder.append(fechaInicio);
		builder.append(", fechaFin=");
		builder.append(fechaFin);
		builder.append(", horasSemana=");
		builder.append(horasSemana);
		builder.append("]");
		return builder.toString();
	}
	
	
}
