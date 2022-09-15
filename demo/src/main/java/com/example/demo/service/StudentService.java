package com.example.demo.service;

import com.example.demo.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

// student in domain, add column class student in student
// service interface of student (implement primary and secondary student)
// primary and secondary students ki two services
// use dependency injection
// class type column in  student

@Service
public interface StudentService {
    List<Student> findByClassType(String classtype);

    boolean validate(int id);
}
