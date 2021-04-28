package com.tutorial.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="columnas_kanban")
public class Columna {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idColumna;
	
	@Column(name="nombreColumna",length = 100,nullable = false)
	private String nombreColumna;
	
	//ConstructoresSS
	public Columna() {
		
	}
	
	public Columna(String nombreColumna) {
		super();
		this.nombreColumna = nombreColumna;
	}

	//getters y setters
	
	public Integer getIdColumna() {
		return idColumna;
	}

	public void setIdColumna(Integer idColumna) {
		this.idColumna = idColumna;
	}

	public String getNombreColumna() {
		return nombreColumna;
	}

	public void setNombreColumna(String nombreColumna) {
		this.nombreColumna = nombreColumna;
	}
}
