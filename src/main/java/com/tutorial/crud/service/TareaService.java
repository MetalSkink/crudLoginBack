package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Tarea;
import com.tutorial.crud.repository.TareaRepository;

@Service
@Transactional
public class TareaService {
	
	@Autowired
	TareaRepository tareaRepository;
	
	public List<Tarea> list(){
		return tareaRepository.findAll();
	}
	
	public Optional<Tarea> getOne(int id){
		return tareaRepository.findById(id);
	}
	
	//public Optional<Proyecto> getByNombreProyecto(String nombre){
	//	return proyectoRepository.findByNombreProyecto(nombre);
	//}
	
	public void save(Tarea tarea) {
		tareaRepository.save(tarea);
	}
	
	public void delete(int id) {
		tareaRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return tareaRepository.existsById(id);
	}

}
