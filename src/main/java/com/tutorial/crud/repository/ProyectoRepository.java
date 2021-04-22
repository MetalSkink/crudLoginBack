package com.tutorial.crud.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tutorial.crud.entity.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer>{
	//Optional<Proyecto> findByNombreProyecto(String nombreProyecto);
	//boolean existByNombreProyecto(String nombreProyecto);
}
