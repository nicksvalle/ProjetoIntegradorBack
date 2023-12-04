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

import com.projeto_integrador.dtos.CourseRequest;
import com.projeto_integrador.dtos.CourseResponse;
import com.projeto_integrador.entities.Course;
import com.projeto_integrador.mappers.CourseMapper;
import com.projeto_integrador.services.CourseService;


@RestController
@RequestMapping("course")
@CrossOrigin

public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getCourse() {
    var course = this.service.getCourses();
    return ResponseEntity.ok(CourseMapper.toDTOList(course));
}


    @GetMapping("{id}")
    public ResponseEntity<CourseResponse>getCourses(@PathVariable long id){
        var courses = this.service.getCourse(id);
        return ResponseEntity.ok(CourseMapper.toDTO(courses));
    }

    @PostMapping
    public ResponseEntity<CourseResponse> save(@Validated @RequestBody CourseRequest courses){
        var savedCourses = this.service.save(courses);

        URI location = ServletUriComponentsBuilder

                .fromCurrentRequest()

                .path("/{id}")

                .buildAndExpand(savedCourses.id())

                .toUri();
                
        return ResponseEntity.created(location).body(savedCourses);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourses(@PathVariable long id){
        this.service.deleteCoursesById(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @PutMapping("{id}")
    public ResponseEntity<Void> update(@Validated @RequestBody Course course,
                                   @PathVariable long id
    ){
   
    this.service.update(id, course);
    return ResponseEntity.ok().build();
    }


}