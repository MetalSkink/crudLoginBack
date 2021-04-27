package com.tutorial.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="accion_kanban")
public class Accion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAccion;
	
	@Column(name="nombreStatus",length = 200,nullable = false)
	private String nombreAccion;
	
	public Accion() {
		
	}

	public Accion(String nombreAccion) {
		super();
		this.nombreAccion = nombreAccion;
	}



	public Integer getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}

	public String getNombreAccion() {
		return nombreAccion;
	}

	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}
}
