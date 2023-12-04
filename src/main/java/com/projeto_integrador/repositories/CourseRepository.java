package com.projeto_integrador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto_integrador.entities.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
    
}