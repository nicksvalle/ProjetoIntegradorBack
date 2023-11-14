package com.projeto_integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador.entities.Aula;

public interface AulaRepository extends JpaRepository<Aula, Long> {
    
}