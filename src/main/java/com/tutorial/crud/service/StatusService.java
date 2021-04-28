package com.tutorial.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.tutorial.crud.entity.Status;
import com.tutorial.crud.repository.StatusRepository;

@Service
@Transactional
public class StatusService {

	@Autowired
	StatusRepository repo;
	
	public List<Status> list(){
		return repo.findAll();
	}
	
	public Optional<Status> getOne(int id){
		return repo.findById(id);
	}
	
	public void save (Status status) {
		repo.save(status);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
	
	public boolean existsById(int id) {
		return repo.existsById(id);
	}
}
