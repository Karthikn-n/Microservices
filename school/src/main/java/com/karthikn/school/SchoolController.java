package com.karthikn.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/schools")
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school){
        service.save(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAll(){
        return ResponseEntity.ok(service.findAllSchool());
    }

    @GetMapping("/student/{school-id}")
    public ResponseEntity<FullSchoolResponse> findAllBySchoolId(@PathVariable("school-id") Integer schoolId){
        return ResponseEntity.ok(service.findAllBySchoolId(schoolId));
    }
}
