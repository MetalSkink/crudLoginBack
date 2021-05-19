package com.tutorial.crud.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

public class BitacoraDto {

	@NotBlank
	private Integer idTareaAsoc;
	
	private Date horaInicio;
	private Date horaFin;
	private Long horasTotales;
	
	public BitacoraDto() {
	}

	public BitacoraDto(@NotBlank Integer idTareaAsoc, Date horaInicio, Date horaFin, Long horasTotales) {
		super();
		this.idTareaAsoc = idTareaAsoc;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.horasTotales = horasTotales;
	}

	public Integer getIdTareaAsoc() {
		return idTareaAsoc;
	}

	public void setIdTareaAsoc(Integer idTareaAsoc) {
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

	public Long getHorasTotales() {
		return horasTotales;
	}

	public void setHorasTotales(Long horasTotales) {
		this.horasTotales = horasTotales;
	}
	
	
}
