package com.projeto_integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    
}