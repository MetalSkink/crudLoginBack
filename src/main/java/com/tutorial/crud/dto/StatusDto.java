package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;

public class StatusDto {
	@NotBlank
	private String nombreStatus;
	
	public StatusDto() {
	}
	
	public StatusDto(@NotBlank String nombreStatus) {
		this.nombreStatus = nombreStatus;
	}

	public String getNombreStatus() {
		return nombreStatus;
	}

	public void setNombreStatus(String nombreStatus) {
		this.nombreStatus = nombreStatus;
	}

}