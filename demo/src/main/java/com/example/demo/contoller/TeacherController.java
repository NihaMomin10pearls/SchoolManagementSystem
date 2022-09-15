package com.example.demo.contoller;

import com.example.demo.TeacherFactory;
import com.example.demo.domain.Teacher;
import com.example.demo.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherFactory teacherFactory;

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

    // all teacher of class type ?
    @GetMapping("/teacher/classtype/{classType}")
    public List<Teacher> show_teacher_of_class(@PathVariable String classType) {
        return teacherFactory.getTeacherService(classType).findClassType(classType);
    }

    // add teacher
    @PostMapping("/teacher/create")
    public Teacher create(@RequestBody Teacher t) {
//        String name = body.get("teacherName");
//        String phone = body.get("teacherPhone");
//        return teacherRepository.save(new Teacher(name, phone));
        return teacherRepository.save(t);
    }

    // update teacher
    @PutMapping("/teacher/update/{id}")
    public Teacher update(@PathVariable int id, @RequestBody Teacher t) {
//        Teacher t_updated = new Teacher(id, t.getTeacherName(), t.getTeacherPhone(), t.getClassType());
        Teacher t_updated = teacherRepository.findById(id).get();
        t_updated.setTeacherName(t.getTeacherName());
        t_updated.setTeacherPhone(t.getTeacherPhone());
        t_updated.setClassType(t.getClassType());
        return teacherRepository.save(t_updated);
    }

    // delete teacher
    @DeleteMapping("/teacher/delete/{id}")
    public Boolean delete(@PathVariable int id) {
        teacherRepository.deleteById(id);
        return true;
    }
}
