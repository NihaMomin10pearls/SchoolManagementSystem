package com.example.demo.contoller;

import com.example.demo.domain.Teacher;
import com.example.demo.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    // all teachers
    @GetMapping("/teacher")
    public List<Teacher> index() {
        System.out.println("Hello Welcome to the Teacher Controller");
        return teacherRepository.findAll();
    }

    // details of teacher of ? id
    @GetMapping("/teacher/{id}")
    public Teacher show_teacher_details(@PathVariable int id) {
        return teacherRepository.findById(id).get();
    }

    // add teacher
    @PostMapping("/teacher/create")
    public Teacher create(@RequestBody Map<String, String> body) {
        String name = body.get("teacherName");
        String phone = body.get("teacherPhone");
        return teacherRepository.save(new Teacher(name, phone));
    }

    // update teacher
    @PutMapping("/teacher/update/{id}")
    public Teacher update(@PathVariable int id, @RequestBody Map<String, String> body) {
        Teacher s = teacherRepository.findById(id).get();
        s.setTeacherName(body.get("teacherName"));
        s.setTeacherPhone(body.get("teacherPhone"));
        return teacherRepository.save(s);
    }

    // delete teacher
    @DeleteMapping("/teacher/delete/{id}")
    public Boolean delete(@PathVariable int id) {
        teacherRepository.deleteById(id);
        return true;
    }
}
