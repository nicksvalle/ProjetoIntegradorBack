package com.projeto_integrador.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_integrador.dtos.TeacherRequest;
import com.projeto_integrador.dtos.TeacherResponse;
import com.projeto_integrador.entities.Teacher;
import com.projeto_integrador.mappers.TeacherMapper;
import com.projeto_integrador.repositories.TeacherRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TeacherService {
    
    @Autowired
    private TeacherRepository repository;

    public List<Teacher> getTeachers(){
        return this.repository.findAll();
    }

    public Teacher getTeacher(long id){
        return this.repository.findById(id).orElseThrow(
                                                () -> new EntityNotFoundException("Teacher not found")

                                                
                                            );
    }

    public void deleteTeachersById(long id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Teacher not found");
        }
    }

    public TeacherResponse save(TeacherRequest teacher){
        var entity = this.repository.save(TeacherMapper.toEntity(teacher));
        return TeacherMapper.toDTO(entity);
    }

    public void update(long id, Teacher teacher) {
        try {
            Teacher updateTeachers = this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Teacher not found")
            );
    
            updateTeachers.setName(teacher.getName());
            updateTeachers.setEmail(teacher.getEmail());
            updateTeachers.setCourse(teacher.getCourse());
            updateTeachers.setDate(teacher.getDate());
            updateTeachers.setDiscipline(teacher.getDiscipline());
    
            this.repository.save(updateTeachers);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Teacher not found");
        }
    }
}
