package com.tutorial.crud.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.tutorial.crud.entity.Accion;
import com.tutorial.crud.entity.Bitacora;
import com.tutorial.crud.entity.Columna;
import com.tutorial.crud.entity.Status;

public class TareaDto {

	@NotBlank
	private String nombreTarea;
	
	@NotBlank
	private Integer idAsociado;
	
	@NotBlank
	private Integer idUsuarioTarea;
	
	//@OneToMany(cascade=CascadeType.ALL)
	//@JoinColumn(name="idTareaAsoc")
	//private List<Bitacora> bitacoras = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="idStatus")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="idAccion")
	private Accion accion;
	
	@ManyToOne
	@JoinColumn(name="idColumna")
	private Columna columna;
	
	private String descripcion;
	
	public TareaDto() {
		
	}

	public TareaDto(@NotBlank String nombreTarea, @NotBlank Integer idAsociado, @NotBlank Integer idUsuarioTarea,
			 Status status, Accion accion, Columna columna, String descripcion) {
		super();
		this.nombreTarea = nombreTarea;
		this.idAsociado = idAsociado;
		this.idUsuarioTarea = idUsuarioTarea;
		this.status = status;
		this.accion = accion;
		this.columna = columna;
		this.descripcion = descripcion;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}

	public Integer getIdAsociado() {
		return idAsociado;
	}

	public void setIdAsociado(Integer idAsociado) {
		this.idAsociado = idAsociado;
	}

	public Integer getIdUsuarioTarea() {
		return idUsuarioTarea;
	}

	public void setIdUsuarioTarea(Integer idUsuarioTarea) {
		this.idUsuarioTarea = idUsuarioTarea;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Accion getAccion() {
		return accion;
	}

	public void setAccion(Accion accion) {
		this.accion = accion;
	}

	public Columna getColumna() {
		return columna;
	}

	public void setColumna(Columna columna) {
		this.columna = columna;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
}