package com.projeto_integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador.entities.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    
}