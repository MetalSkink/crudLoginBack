package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.crud.entity.Columna;

import com.tutorial.crud.repository.ColumnaRepository;

@Service
@Transactional
public class ColumnaService {
	@Autowired
	ColumnaRepository repo;
	
	public List<Columna> list(){
		return repo.findAll();
	}
	
	public Optional<Columna> getOne(int id){
		return repo.findById(id);
	}
	
	public void save (Columna columna) {
		repo.save(columna);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return repo.existsById(id);
	}
}
