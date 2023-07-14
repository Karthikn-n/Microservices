package com.karthikn.school.client;


import com.karthikn.school.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-client",url = "application.config.students-url")
public interface StudentClient {

    @GetMapping("/school/{school-id}")
    List<Student> findAllStudentBySchool(@PathVariable("school-id") Integer schoolId);
}
