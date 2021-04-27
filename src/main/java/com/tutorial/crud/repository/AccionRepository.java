package com.tutorial.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Accion;

@Repository
public interface AccionRepository extends JpaRepository<Accion, Integer>{

}
