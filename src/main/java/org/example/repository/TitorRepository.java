package org.example.repository;


import org.example.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitorRepository extends JpaRepository<Alumno, Integer> {



}
