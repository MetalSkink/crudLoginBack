package com.tutorial.crud.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Proyecto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProyecto;
	
	@Column(name="nombreProyecto",length = 200,nullable = false)
	private String nombreProyecto;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idAsociado")
	private List<Tarea> tareas =new ArrayList<>();
	
	public Proyecto() {
	}
	
	public Proyecto(String nombreProyecto) {
		this.nombreProyecto=nombreProyecto;
	}
	
	//getters y setters
	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
}
