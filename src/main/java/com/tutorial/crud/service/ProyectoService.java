package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Proyecto;

import com.tutorial.crud.repository.ProyectoRepository;


@Service
@Transactional
public class ProyectoService {
	
	@Autowired
	ProyectoRepository proyectoRepository;
	
	public List<Proyecto> list(){
		return proyectoRepository.findAll();
	}
	
	public Optional<Proyecto> getOne(int id){
		return proyectoRepository.findById(id);
	}
	
	//public Optional<Proyecto> getByNombreProyecto(String nombre){
	//	return proyectoRepository.findByNombreProyecto(nombre);
	//}
	
	public void save(Proyecto proyecto) {
		proyectoRepository.save(proyecto);
	}
	
	public void delete(int id) {
		proyectoRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return proyectoRepository.existsById(id);
	}
	
	//public boolean existsByNombreProyecto(String nombreProyecto) {
	//	return proyectoRepository.existByNombreProyecto(nombreProyecto);
	//}
}
