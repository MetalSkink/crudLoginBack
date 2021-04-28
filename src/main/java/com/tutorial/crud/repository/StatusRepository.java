package com.tutorial.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutorial.crud.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer>{

}
