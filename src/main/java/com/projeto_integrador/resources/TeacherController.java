package com.projeto_integrador.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto_integrador.entities.Teacher;
import com.projeto_integrador.dtos.TeacherRequest;
import com.projeto_integrador.dtos.TeacherResponse;
import com.projeto_integrador.mappers.TeacherMapper;
import com.projeto_integrador.services.TeacherService;

@RestController
@RequestMapping("teachers")
@CrossOrigin

public class TeacherController { 
    @Autowired
    private TeacherService service;

    @GetMapping
    public ResponseEntity<List<TeacherResponse>> getTeacher() {
    var professor = this.service.getTeachers();
    return ResponseEntity.ok(TeacherMapper.toDTOList(professor));
}



    @GetMapping("{id}")
    public ResponseEntity<TeacherResponse>getTeachers(@PathVariable long id){
        var teachers = this.service.getTeacher(id);
        return ResponseEntity.ok(TeacherMapper.toDTO(teachers));
    }
    
    @PostMapping
    public ResponseEntity<TeacherResponse> save(@Validated @RequestBody TeacherRequest teachers){
        var savedTeachers = this.service.save(teachers);

        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedTeachers.id())

                .toUri();
                
        return ResponseEntity.created(location).body(savedTeachers);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTeachers(@PathVariable long id){
        this.service.deleteTeachersById(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Teacher teacher,
                                   @PathVariable long id
    ){
   
        this.service.update(id, teacher);
        return ResponseEntity.ok().build();
    }



}