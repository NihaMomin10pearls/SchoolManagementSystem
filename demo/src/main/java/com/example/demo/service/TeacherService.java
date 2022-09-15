package com.example.demo.service;

import com.example.demo.domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {

    List<Teacher> findClassType(String classType);

    boolean validate(int id);

}
