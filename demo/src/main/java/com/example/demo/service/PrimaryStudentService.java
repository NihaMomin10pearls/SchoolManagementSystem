//package com.example.demo.service;
//
//import com.example.demo.domain.Student;
//import com.example.demo.respository.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class PrimaryStudentService implements StudentService{
//
//    @Autowired
//    StudentRepository studentRepository;
//
//    @Override
//    public List<Student> findByClassType(String classType) {
//        return studentRepository.findByClassType(classType);
//    }
//
//}