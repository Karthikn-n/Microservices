package com.karthikn.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Student student){
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll(){
        return ResponseEntity.ok(service.findAllStudent());
    }


    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> findAll(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(service.findAllStudentBySchoolId(schoolId));
    }

}
