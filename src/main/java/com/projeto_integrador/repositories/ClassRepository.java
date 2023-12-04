package com.projeto_integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador.entities.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {
    
}