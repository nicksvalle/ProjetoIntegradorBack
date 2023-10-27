package com.projeto_integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador.entities.Disciplinas;

public interface DisciplinasRepository extends JpaRepository<Disciplinas, Long> {
    
}