package com.projeto_integrador.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="TBL_PROFESSOR")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024, nullable = false, name = "Professor_name")
    private String name;

    @Column(length = 1024, nullable = false, name = "Professor_email")
    private String email;

    @Column(length = 1024, nullable = false, name = "Professor_course")
    private List<String> course;

    @Column(length = 1024, nullable = false, name = "Professor_date")
    private String date;

    @Column(length = 1024, nullable = false, name = "Professor_materia")
    private List<String> materia;

        // Getters e Setters
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public String getEmail() {
            return email;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }

        public List<String> getCourse() {
            return course;
        }
    
        public void setCourse(List<String> course) {
            this.course = course;
        }

        public String getDate() {
            return date;
        }
    
        public void setDate(String date) {
            this.date = date;
        }
        
        public List<String> getMateria() {
            return materia;
        }
    
        public void setMateria(List<String> materia) {
            this.materia = materia;
        }


        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (id ^ (id >>> 32));
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Professor other = (Professor) obj;
            if (id != other.id)
                return false;
            return true;
        }
        
    }
    
    

