package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;

public class ProyectoDto {
	
	@NotBlank
	private String nombreProyecto;
	
	public ProyectoDto() {
	}
	
	public ProyectoDto(@NotBlank String nombreProyecto) {
		this.nombreProyecto=nombreProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	
}
