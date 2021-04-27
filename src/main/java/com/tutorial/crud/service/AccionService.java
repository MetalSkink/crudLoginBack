package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Accion;
import com.tutorial.crud.repository.AccionRepository;

@Service
@Transactional
public class AccionService {
	
	@Autowired
	AccionRepository accionRepository;

	public List<Accion> list(){
		return accionRepository.findAll();
	}
	
	public Optional<Accion> getOne(int id){
		return accionRepository.findById(id);
	}
	
	public void save (Accion accion) {
		accionRepository.save(accion);
	}
	
	public void delete(int id) {
		accionRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return accionRepository.existsById(id);
	}
}
