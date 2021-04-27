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

import com.tutorial.crud.dto.AccionDto;
import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.entity.Accion;
import com.tutorial.crud.service.AccionService;

@RestController
@RequestMapping("/acciones")
@CrossOrigin(origins = "http://localhost:4200")
public class AccionController {

	@Autowired
	AccionService accionService;

	@GetMapping
	public ResponseEntity<List<Accion>> list(){
		List<Accion> list = accionService.list();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Accion> getById(@PathVariable("id") int id){
		if(!accionService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Accion accion = accionService.getOne(id).get();
		return new ResponseEntity<Accion>(accion, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody AccionDto accionDto){
		if(StringUtils.isBlank(accionDto.getNombreAccion()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Accion accion = new Accion(accionDto.getNombreAccion());
		accionService.save(accion);
		return new ResponseEntity(new Mensaje("proyecto creado"), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		if(!accionService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		accionService.delete(id);
		return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody AccionDto accionDto){
		if(!accionService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(accionDto.getNombreAccion()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Accion accion = accionService.getOne(id).get();
		accion.setNombreAccion(accionDto.getNombreAccion());
		accionService.save(accion);
		return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
	}

}