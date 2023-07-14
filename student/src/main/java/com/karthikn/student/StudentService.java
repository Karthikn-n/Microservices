package com.karthikn.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void saveStudent(Student student){
        repository.save(student);
    }

    public List<Student> findAllStudent(){
        return repository.findAll();
    }


    public List<Student> findAllStudentBySchoolId(Integer schoolId) {
        return repository.findAllBySchoolId(schoolId);
    }
}