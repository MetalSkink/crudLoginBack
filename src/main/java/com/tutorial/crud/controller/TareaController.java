package com.tutorial.crud.controller;

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

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.ProyectoDto;
import com.tutorial.crud.dto.TareaDto;
import com.tutorial.crud.entity.Columna;
import com.tutorial.crud.entity.Proyecto;
import com.tutorial.crud.entity.Status;
import com.tutorial.crud.entity.Tarea;
import com.tutorial.crud.service.TareaService;

@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "http://localhost:4200")
public class TareaController {
	
	@Autowired
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
		//if(StringUtils.isBlank(tareaDto.getIdAsociado()))
			//return new ResponseEntity(new Mensaje("el id asociado es obligatorio"), HttpStatus.BAD_REQUEST);			
		Tarea tarea = new Tarea(tareaDto.getNombreTarea(),tareaDto.getIdAsociado(),tareaDto.getIdUsuarioTarea(),tareaDto.getStatus(),tareaDto.getAccion(),tareaDto.getColumna(),tareaDto.getDescripcion());
		tareaService.save(tarea);
		return new ResponseEntity(new Mensaje("tarea creada"), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
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
		return new ResponseEntity(new Mensaje("tarea actualizada"), HttpStatus.OK);
	}
	
	@PutMapping("/bajar/{id}")
	public ResponseEntity<?> bajar(@PathVariable("id")int id, @RequestBody TareaDto tareaDto){
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
		//nueva Columna
		Columna nuevaColumna= tareaDto.getColumna();
		nuevaColumna.setIdColumna(nuevaColumna.getIdColumna()-1);
		tarea.setColumna(nuevaColumna);
		tarea.setDescripcion(tareaDto.getDescripcion());
		tareaService.save(tarea);
		return new ResponseEntity(new Mensaje("producto actualizado"), HttpStatus.OK);
	}
	
	@PutMapping("/subir/{id}")
	public ResponseEntity<?> subir(@PathVariable("id")int id, @RequestBody TareaDto tareaDto){
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
		//nueva Columna
		Columna nuevaColumna= tareaDto.getColumna();
		nuevaColumna.setIdColumna(nuevaColumna.getIdColumna()+1);
		tarea.setColumna(nuevaColumna);
		tarea.setDescripcion(tareaDto.getDescripcion());
		tareaService.save(tarea);
		return new ResponseEntity(new Mensaje("tarea actualizada"), HttpStatus.OK);
	}
	
	@PutMapping("/progreso/{id}")
	public ResponseEntity<?> statusProgreso(@PathVariable("id")int id, @RequestBody TareaDto tareaDto){
		if(!tareaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe la tarea con ese ID"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(tareaDto.getNombreTarea()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Tarea tarea = tareaService.getOne(id).get();
		tarea.setNombreTarea(tareaDto.getNombreTarea());
		tarea.setIdAsociado(tareaDto.getIdAsociado());
		tarea.setIdUsuarioTarea(tareaDto.getIdUsuarioTarea());
		//tarea.setStatus(tareaDto.getStatus());
		tarea.setAccion(tareaDto.getAccion());
		tarea.setColumna(tareaDto.getColumna());
		//nuevo status
		Status nuevoStatus = tareaDto.getStatus();
		//Columna nuevaColumna= tareaDto.getColumna();
		//nuevaColumna.setIdColumna(nuevaColumna.getIdColumna()+1);
		nuevoStatus.setIdStatus(2);
		tarea.setStatus(nuevoStatus);
		//tarea.setColumna(nuevaColumna);
		tarea.setDescripcion(tareaDto.getDescripcion());
		tareaService.save(tarea);
		return new ResponseEntity(new Mensaje("tarea actualizada"), HttpStatus.OK);
	}
	
	@PutMapping("/pausar/{id}")
	public ResponseEntity<?> statusPausar(@PathVariable("id")int id, @RequestBody TareaDto tareaDto){
		if(!tareaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe la tarea con ese ID"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(tareaDto.getNombreTarea()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Tarea tarea = tareaService.getOne(id).get();
		tarea.setNombreTarea(tareaDto.getNombreTarea());
		tarea.setIdAsociado(tareaDto.getIdAsociado());
		tarea.setIdUsuarioTarea(tareaDto.getIdUsuarioTarea());
		//tarea.setStatus(tareaDto.getStatus());
		tarea.setAccion(tareaDto.getAccion());
		tarea.setColumna(tareaDto.getColumna());
		//nuevo status
		Status nuevoStatus = tareaDto.getStatus();
		//Columna nuevaColumna= tareaDto.getColumna();
		//nuevaColumna.setIdColumna(nuevaColumna.getIdColumna()+1);
		nuevoStatus.setIdStatus(3);
		tarea.setStatus(nuevoStatus);
		//tarea.setColumna(nuevaColumna);
		tarea.setDescripcion(tareaDto.getDescripcion());
		tareaService.save(tarea);
		return new ResponseEntity(new Mensaje("tarea actualizada"), HttpStatus.OK);
	}
	
	@PutMapping("/terminar/{id}")
	public ResponseEntity<?> statusTerminar(@PathVariable("id")int id, @RequestBody TareaDto tareaDto){
		if(!tareaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe la tarea con ese ID"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(tareaDto.getNombreTarea()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Tarea tarea = tareaService.getOne(id).get();
		tarea.setNombreTarea(tareaDto.getNombreTarea());
		tarea.setIdAsociado(tareaDto.getIdAsociado());
		tarea.setIdUsuarioTarea(tareaDto.getIdUsuarioTarea());
		tarea.setAccion(tareaDto.getAccion());
		tarea.setColumna(tareaDto.getColumna());
		//nuevo status
		Status nuevoStatus = tareaDto.getStatus();
		nuevoStatus.setIdStatus(4);
		tarea.setStatus(nuevoStatus);
		tarea.setDescripcion(tareaDto.getDescripcion());
		tareaService.save(tarea);
		return new ResponseEntity(new Mensaje("tarea actualizada"), HttpStatus.OK);
	}
	
	@PutMapping("/cancelar/{id}")
	public ResponseEntity<?> statusCancelar(@PathVariable("id")int id, @RequestBody TareaDto tareaDto){
		if(!tareaService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe la tarea con ese ID"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(tareaDto.getNombreTarea()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Tarea tarea = tareaService.getOne(id).get();
		tarea.setNombreTarea(tareaDto.getNombreTarea());
		tarea.setIdAsociado(tareaDto.getIdAsociado());
		tarea.setIdUsuarioTarea(tareaDto.getIdUsuarioTarea());
		tarea.setAccion(tareaDto.getAccion());
		tarea.setColumna(tareaDto.getColumna());
		//nuevo status
		Status nuevoStatus = tareaDto.getStatus();
		nuevoStatus.setIdStatus(5);
		tarea.setStatus(nuevoStatus);
		tarea.setDescripcion(tareaDto.getDescripcion());
		tareaService.save(tarea);
		return new ResponseEntity(new Mensaje("tarea actualizada"), HttpStatus.OK);
	}
	
	
	
}
