package com.tutorial.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status_kanban")
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStatus;
	
	@Column(name="nombreStatus",length = 200,nullable = false)
	private String nombreStatus;
	
	public Status() {
	}

	public Status(String nombreStatus) {
		this.nombreStatus = nombreStatus;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getNombreStatus() {
		return nombreStatus;
	}

	public void setNombreStatus(String nombreStatus) {
		this.nombreStatus = nombreStatus;
	}
}
