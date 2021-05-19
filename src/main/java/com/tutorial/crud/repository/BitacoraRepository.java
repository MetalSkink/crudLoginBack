package com.tutorial.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Bitacora;

@Repository
public interface BitacoraRepository extends JpaRepository<Bitacora, Integer>{

	List<Bitacora> findByIdTareaAsoc(Integer idTarea);
	
	
}
