package com.tutorial.crud.controller;

import java.net.URI;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.ProyectoDto;
import com.tutorial.crud.entity.Proyecto;
import com.tutorial.crud.service.ProyectoService;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectoController {
	
	@Autowired
	ProyectoService proyectoService;
	
	@GetMapping
	public ResponseEntity<List<Proyecto>> list(){
		List<Proyecto> list = proyectoService.list();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
		if(!proyectoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Proyecto proyecto = proyectoService.getOne(id).get();
		return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto){
		if(StringUtils.isBlank(proyectoDto.getNombreProyecto()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Proyecto proyecto = new Proyecto(proyectoDto.getNombreProyecto());
		proyectoService.save(proyecto);
		return new ResponseEntity(new Mensaje("proyecto creado"), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		if(!proyectoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		proyectoService.delete(id);
		return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody ProyectoDto proyectoDto){
		if(!proyectoService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(proyectoDto.getNombreProyecto()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Proyecto proyecto = proyectoService.getOne(id).get();
		proyecto.setNombreProyecto(proyectoDto.getNombreProyecto());
		proyectoService.save(proyecto);
		return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
	}
	
}
