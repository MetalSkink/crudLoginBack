package com.tutorial.crud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="bitacora")
public class Bitacora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBitacora;
	
	@Column(name="idTareaAsoc",nullable = false)
	private Integer idTareaAsoc;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "hora_inicio", nullable=false)
	private Date horaInicio;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name= "hora_fin", nullable=false)
	private Date horaFin;
	
	@Column(name= "horas_totales")
	private Integer horasTotales;

	//getters y setters
	
	//setters y getters
		public Integer getIdBitacora() {
			return idBitacora;
		}

		public void setIdBitacora(Integer idBitacora) {
			this.idBitacora = idBitacora;
		}

		public Integer getIdTarea() {
			return idTareaAsoc;
		}

		public void setIdTarea(Integer idTareaAsoc) {
			this.idTareaAsoc = idTareaAsoc;
		}

		public Date getHoraInicio() {
			return horaInicio;
		}

		public void setHoraInicio(Date horaInicio) {
			this.horaInicio = horaInicio;
		}

		public Date getHoraFin() {
			return horaFin;
		}

		public void setHoraFin(Date horaFin) {
			this.horaFin = horaFin;
		}

		public Integer getHorasTotales() {
			return horasTotales;
		}

		public void setHorasTotales(Integer horasTotales) {
			this.horasTotales = horasTotales;
		}
}
