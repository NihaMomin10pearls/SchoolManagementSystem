package com.example.demo.service;

import com.example.demo.domain.Teacher;
import com.example.demo.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubTeacherService implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> findClassType(String classType) {
        return teacherRepository.findByClassType(classType);
    }

    @Override
    public boolean validate(int id) {
        return (teacherRepository.existsById(id));
    }

}
