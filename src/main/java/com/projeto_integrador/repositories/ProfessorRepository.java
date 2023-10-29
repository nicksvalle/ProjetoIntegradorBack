package com.projeto_integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    
}