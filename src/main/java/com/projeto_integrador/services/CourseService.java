package com.projeto_integrador.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.dtos.CourseRequest;
import com.projeto_integrador.dtos.CourseResponse;
import com.projeto_integrador.entities.Course;
import com.projeto_integrador.mappers.CourseMapper;
import com.projeto_integrador.repositories.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository repository;

    public List<Course> getCourses(){
        return this.repository.findAll();
    }

    public Course getCourse(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Course not found")

                                                
                                            );
    }

    public void deleteCoursesById(long id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Course not found");
        }
    }

    public CourseResponse save(CourseRequest course){
        var entity = this.repository.save(CourseMapper.toEntity(course));
        return CourseMapper.toDTO(entity);
    }

    public void update(long id, Course course) {
        try {
            Course updateCourses = this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Course not found")
            );
    
            updateCourses.setTitle(course.getTitle());
            updateCourses.setDiscipline(course.getDiscipline());
            updateCourses.setCourse(course.getCourse());
            updateCourses.setPeriod(course.getPeriod());
    
            this.repository.save(updateCourses);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Course not found");
        }
    }
}
