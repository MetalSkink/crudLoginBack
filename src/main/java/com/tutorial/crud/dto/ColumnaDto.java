package com.tutorial.crud.dto;

import javax.validation.constraints.NotBlank;

public class ColumnaDto {
	@NotBlank
	private String nombreColumna;
	
	public ColumnaDto(){
		
	}

	public ColumnaDto(@NotBlank String nombreColumna) {
		this.nombreColumna = nombreColumna;
	}

	public String getNombreColumna() {
		return nombreColumna;
	}

	public void setNombreColumna(String nombreColumna) {
		this.nombreColumna = nombreColumna;
	}
	
}
