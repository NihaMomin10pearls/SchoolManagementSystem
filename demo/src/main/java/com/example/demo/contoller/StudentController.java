package com.example.demo.contoller;

import com.example.demo.domain.Student;
import com.example.demo.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    // all students
    @GetMapping("/student")
    public List<Student> index() {
        System.out.println("Hello Welcome to the Student Controller");
        return studentRepository.findAll();
    }

    // details of student of ? id
    @GetMapping("/student/{id}")
    public Student show_student_details(@PathVariable int id) {
        return studentRepository.findById(id).get();
    }

    // add student
    @PostMapping("/student/create")
    public Student create(@RequestBody Student s) {
        return studentRepository.save(s);
    }

    // update student
    @PutMapping("/student/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Map<String, String> body) {
        Student s = studentRepository.findById(id).get();
        s.setStudentName(body.get("studentName"));
        s.setStudentPhone(body.get("studentPhone"));
        return studentRepository.save(s);
    }

    // delete student
    @DeleteMapping("/student/delete/{id}")
    public Boolean delete(@PathVariable int id) {
        studentRepository.deleteById(id);
        return true;
    }


}
