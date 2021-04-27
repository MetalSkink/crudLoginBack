package com.tutorial.crud.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.ProyectoDto;
import com.tutorial.crud.dto.TareaDto;
import com.tutorial.crud.entity.Proyecto;
import com.tutorial.crud.entity.Tarea;
import com.tutorial.crud.service.TareaService;

@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "http://localhost:4200")
public class TareaController {
	TareaService tareaService;
	
	@GetMapping
	public ResponseEntity<List<Tarea>> list(){
		List<Tarea> list = tareaService.list();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tarea> getById(@PathVariable("id") int id){
		if(!tareaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Tarea tarea = tareaService.getOne(id).get();
		return new ResponseEntity<Tarea>(tarea, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody TareaDto tareaDto){
		if(StringUtils.isBlank(tareaDto.getNombreTarea()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(tareaDto.getDescripcion()))
			return new ResponseEntity(new Mensaje("el id asociado es obligatorio"), HttpStatus.BAD_REQUEST);			
		Tarea tarea = new Tarea(tareaDto.getNombreTarea(),tareaDto.getIdAsociado(),tareaDto.getIdUsuarioTarea(),tareaDto.getStatus(),tareaDto.getAccion(),tareaDto.getColumna(),tareaDto.getDescripcion());
		tareaService.save(tarea);
		return new ResponseEntity(new Mensaje("tarea creada"), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		if(!tareaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		tareaService.delete(id);
		return new ResponseEntity(new Mensaje("tarea eliminada"), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody TareaDto tareaDto){
		if(!tareaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe la tarea con ese ID"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(tareaDto.getNombreTarea()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Tarea tarea = tareaService.getOne(id).get();
		tarea.setNombreTarea(tareaDto.getNombreTarea());
		tarea.setIdAsociado(tareaDto.getIdAsociado());
		tarea.setIdUsuarioTarea(tareaDto.getIdUsuarioTarea());
		tarea.setStatus(tareaDto.getStatus());
		tarea.setAccion(tareaDto.getAccion());
		tarea.setColumna(tareaDto.getColumna());
		tarea.setDescripcion(tareaDto.getDescripcion());
		tareaService.save(tarea);
		return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
	}
}
