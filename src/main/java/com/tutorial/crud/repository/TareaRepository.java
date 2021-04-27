package com.tutorial.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

}
