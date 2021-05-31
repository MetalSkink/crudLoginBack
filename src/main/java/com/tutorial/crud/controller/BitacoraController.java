package com.tutorial.crud.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutorial.crud.dto.BitacoraDto;
import com.tutorial.crud.dto.Mensaje;

import com.tutorial.crud.entity.Bitacora;
import com.tutorial.crud.entity.Tarea;
import com.tutorial.crud.service.BitacoraService;
import com.tutorial.crud.service.TareaService;

@RestController
@RequestMapping("/bitacoras")
@CrossOrigin(origins = "http://localhost:4200")
public class BitacoraController {

	@Autowired
	BitacoraService bitacoraService;
	
	@Autowired 
	TareaService tareaService;

	@GetMapping
	public ResponseEntity<List<Bitacora>> list(){
		List<Bitacora> list = bitacoraService.list();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Bitacora> getById(@PathVariable("id") int id){
		if(!bitacoraService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe la bitacora"), HttpStatus.NOT_FOUND);
		Bitacora bitacora = bitacoraService.getOne(id).get();
		return new ResponseEntity<Bitacora>(bitacora, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody BitacoraDto bitacoraDto){
		//if(StringUtils.isBlank(bitacoraDto.))
			//return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
		Bitacora bitacora = new Bitacora(bitacoraDto.getIdTareaAsoc(),bitacoraDto.getHoraInicio(),bitacoraDto.getHoraFin(),bitacoraDto.getHorasTotales());
		bitacoraService.save(bitacora);
		return new ResponseEntity(new Mensaje("bitacora creada"), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody BitacoraDto bitacoraDto){
		if(!bitacoraService.existsById(id))
			return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Bitacora bitacora = bitacoraService.getOne(id).get();
		//proyecto.setNombreProyecto(proyectoDto.getNombreProyecto());
		bitacora.setHoraInicio(bitacoraDto.getHoraInicio());
		bitacora.setHoraFin(bitacoraDto.getHoraFin());
		bitacora.setHorasTotales(bitacoraDto.getHorasTotales());
		bitacoraService.save(bitacora);
		return new ResponseEntity(new Mensaje("bitacora actualizada"), HttpStatus.OK);
	}
	
	@PostMapping("/iniciarBitacora")
	public ResponseEntity<?> iniciar(@RequestBody BitacoraDto bitacoraDto){
		Bitacora bitacora= new Bitacora(bitacoraDto.getIdTareaAsoc(),bitacoraDto.getHoraInicio(),bitacoraDto.getHoraFin(),bitacoraDto.getHorasTotales());

		//Bitacora bitacora = new Bitacora(id,horaParseada,0,0);
		
		bitacoraService.save(bitacora);
		return new ResponseEntity(new Mensaje("bitacora creada"), HttpStatus.OK);
	}
	
	@PutMapping("/pausarBitacora/{id}")
	public ResponseEntity<?> pausar(@PathVariable("id")int id, @RequestBody BitacoraDto bitacoraDto){
		//if(!bitacoraService.existsById(id))
			//return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		int lastIndx=0;
		List<Bitacora> bitacoras = bitacoraService.buscaBitacora(id);
		
		for(int i=0; i<bitacoras.size();i++) {
			lastIndx= bitacoras.get(i).getIdBitacora();
		}
		System.out.println(lastIndx);
		Bitacora bitacoraFound= bitacoraService.getOne(lastIndx).get();
		bitacoraFound.setHoraFin(bitacoraDto.getHoraFin());
		
		Date horaInicio = bitacoraFound.getHoraInicio();
		Date horaFin    = bitacoraFound.getHoraFin();

		long diff = horaFin.getTime() - horaInicio.getTime();
		System.out.println(horaInicio);
		System.out.println(horaFin);
		TimeUnit time = TimeUnit.MINUTES; 
		long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
		//System.out.println(diff);
		//System.out.println(diffrence);
		bitacoraFound.setHorasTotales(diffrence);
		
		bitacoraService.save(bitacoraFound);
		
		
		
		//Tarea tarea =  tareaService.getOne(id).get();
		//List<Bitacora> bitacoras = tarea.getBitacoras();
		//System.out.println(bitacoras);
		//bitacoraFinal = bitacoras.
		
		//bitacora.setHorasTotales(bitacoraDto.getHorasTotales());
		///bitacoraService.save(bitacora);
		return new ResponseEntity(new Mensaje("bitacora terminada"), HttpStatus.OK);
	}
}