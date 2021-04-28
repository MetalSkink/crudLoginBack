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

import com.tutorial.crud.dto.Mensaje;
import com.tutorial.crud.dto.StatusDto;
import com.tutorial.crud.entity.Status;
import com.tutorial.crud.service.StatusService;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {

	@Autowired
	StatusService statusService;
	
	@GetMapping
	public ResponseEntity<List<Status>> list(){
		List<Status> list = statusService.list();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody StatusDto statusDto){
		if(StringUtils.isBlank(statusDto.getNombreStatus()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Status status = new Status(statusDto.getNombreStatus());
		statusService.save(status);
		return new ResponseEntity(new Mensaje("status creado"), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id")int id){
		if(!statusService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		statusService.delete(id);
		return new ResponseEntity(new Mensaje("status eliminado"), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody StatusDto statusDto){
		if(!statusService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		if(StringUtils.isBlank(statusDto.getNombreStatus()))
			return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Status status = statusService.getOne(id).get();
		status.setNombreStatus(statusDto.getNombreStatus());
		statusService.save(status);
		return new ResponseEntity(new Mensaje("status actualizado"), HttpStatus.OK);
	}
}
