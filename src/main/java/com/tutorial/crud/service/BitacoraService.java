package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Bitacora;
import com.tutorial.crud.repository.BitacoraRepository;

@Service
@Transactional
public class BitacoraService {
	
	@Autowired
	BitacoraRepository bitacoraRepository;
	
	public List<Bitacora> list(){
		return bitacoraRepository.findAll();
	}
	
	public Optional<Bitacora> getOne(int id){
		return bitacoraRepository.findById(id);
	}
	
	//public Optional<Bitacora> getByNombre(String nombre){
		//return bitacoraRepository.
	//}
	
	public void save(Bitacora bitacora) {
		bitacoraRepository.save(bitacora);
	}
	
	public void delete(int id) {
		bitacoraRepository.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return bitacoraRepository.existsById(id);
	}
	
	public List<Bitacora> buscaBitacora(Integer id){
		return bitacoraRepository.findByIdTareaAsoc(id);
	}
}
