package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;

public class AccionDto {
	
	@NotBlank
	private String nombreAccion;
	
	public AccionDto() {
	}

	public AccionDto(@NotBlank String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}

	public String getNombreAccion() {
		return nombreAccion;
	}

	public void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}
	
}
