package com.projeto_integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador.entities.Curso;


public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}