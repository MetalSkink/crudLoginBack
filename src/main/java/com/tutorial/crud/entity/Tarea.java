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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTarea;
	
	@Column(name="nombreTarea",length = 150,nullable = false)
	private String nombreTarea;
	
	@Column(name="idAsociado",nullable = true)
	private Integer idAsociado;

	@Column(name="idUsuarioTarea")
	private Integer idUsuarioTarea;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idTareaAsoc")
	private List<Bitacora> bitacoras = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="idStatus")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="idAccion")
	private Accion accion;
	
	@ManyToOne
	@JoinColumn(name="idColumna")
	private Columna columna;
	
	@Column(name="descripcion",length = 255,nullable = true)
	private String descripcion;
	public String getDescripcion() {return descripcion;}
	public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
	
	@Column(name="minutosAcumulados")
	private Long minutosAcumulados;
	public Long getMinutosAcumulados() {return minutosAcumulados;}
	public void setMinutosAcumulados(Long minutosAcumulados) {this.minutosAcumulados = minutosAcumulados;}
	
	
	//Constructor
	
	
	public Tarea() {
	}
	
	//setters y getters
	
		public Tarea(String nombreTarea, Integer idAsociado, Integer idUsuarioTarea, 
			Status status, Accion accion, Columna columna, String descripcion, Long minutosAcumulados) {
		this.nombreTarea = nombreTarea;
		this.idAsociado = idAsociado;
		this.idUsuarioTarea = idUsuarioTarea;
		//this.bitacoras = bitacoras;
		this.status = status;
		this.accion = accion;
		this.columna = columna;
		this.descripcion = descripcion;
		this.minutosAcumulados = minutosAcumulados;
	}
		public Integer getIdTarea() {
			return idTarea;
		}
		public void setIdTarea(Integer idTarea) {
			this.idTarea = idTarea;
		}
		public String getNombreTarea() {
			return nombreTarea;
		}
		public void setNombreTarea(String nombreTarea) {
			this.nombreTarea = nombreTarea;
		}

		public Integer getIdUsuarioTarea() {
			return idUsuarioTarea;
		}
		public void setIdUsuarioTarea(Integer idUsuarioTarea) {
			this.idUsuarioTarea = idUsuarioTarea;
		}
		
		public Integer getIdAsociado() {
			return idAsociado;
		}
		public void setIdAsociado(Integer idAsociado) {
			this.idAsociado = idAsociado;
		}
		public List<Bitacora> getBitacoras() {
			return bitacoras;
		}
		public void setBitacoras(List<Bitacora> bitacoras) {
			this.bitacoras = bitacoras;
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
}
