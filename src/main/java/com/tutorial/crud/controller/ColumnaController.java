package com.tutorial.crud.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.crud.dto.ColumnaDto;
import com.tutorial.crud.dto.Mensaje;

import com.tutorial.crud.entity.Columna;

import com.tutorial.crud.service.ColumnaService;

@RestController
@RequestMapping("/columnas")
@CrossOrigin(origins = "http://localhost:4200")
public class ColumnaController {

	@Autowired
	ColumnaService columnaService;
	
	@GetMapping
	public ResponseEntity<List<Columna>> list(){
		List<Columna> list = columnaService.list();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ColumnaDto columnaDto){
		if(StringUtils.isBlank(columnaDto.getNombreColumna()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Columna columna = new Columna(columnaDto.getNombreColumna());
		columnaService.save(columna);
		return new ResponseEntity(new Mensaje("columna creada"), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		if(!columnaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		columnaService.delete(id);
		return new ResponseEntity(new Mensaje("columna eliminada"), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ColumnaDto columnaDto){
		if(!columnaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(columnaDto.getNombreColumna()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Columna columna = columnaService.getOne(id).get();
		columna.setNombreColumna(columnaDto.getNombreColumna());
		columnaService.save(columna);
		return new ResponseEntity(new Mensaje("columna actualizada"), HttpStatus.OK);
	}
}
