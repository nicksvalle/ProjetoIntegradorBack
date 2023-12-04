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
@Table(name ="courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024, nullable = false, name = "title")
    private String title;

    @Column(length = 1024, nullable = false, name = "discipline")
    private String discipline;

    @Column(length = 1024, nullable = false, name = "course")
    private String course;

    @Column(length = 1024, nullable = false, name = "acronym")
    private String acronym;

    @Column(length = 1024, nullable = false, name = "teacher")
    private List<String> teacher;

    @Column(length = 1024, nullable = false, name = "periodo")
    private String period;
    
    
        public Long getId() {
            return id;
        }
    
        public void setId(Long id) {
            this.id = id;
        }
    
        public String getTitle() {
            return title;
        }
    
        public void setTitle(String title) {
            this.title = title;
        }
    
        public String getDiscipline() {
            return discipline;
        }
    
        public void setDiscipline(String discipline) {
            this.discipline = discipline;
        }
    
        public String getCourse() {
            return course;
        }
    
        public void setCourse(String course) {
            this.course = course;
        }

        public List<String> getTeacher() {
            return teacher;
        }

        public void setTeacher(List<String> teacher) {
            this.teacher = teacher;
        }

        public String getPeriod() {
            return period;
        }

        public void setPeriod(String period) {
            this.period = period;
        }
        public String getAcronym() {
            return acronym;
        }

        public void setAcronym(String acronym) {
            this.acronym = acronym;
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
            Course other = (Course) obj;
            if (id != other.id)
                return false;
            return true;
        }      
        
    }
    
    



