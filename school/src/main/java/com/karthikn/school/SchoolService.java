package com.karthikn.school;

import com.karthikn.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;
    private final StudentClient client;

    public void save(School school){
        repository.save(school);
    }

    public List<School> findAllSchool(){
        return repository.findAll();
    }

    public FullSchoolResponse findAllBySchoolId(Integer schoolId){
        var schools= repository.findById(schoolId)
                .orElse(School.builder()
                        .email("NOT FOUND")
                        .name("NOT FOUND")
                        .build());
        var students= client.findAllStudentBySchool(schoolId); // It will fetch the students from stuent microservice
        return FullSchoolResponse.builder()
                .email(schools.getEmail())
                .name(schools.getName())
                .students(students)
                .build();
    }
}
