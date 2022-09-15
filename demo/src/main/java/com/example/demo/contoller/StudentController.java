package com.example.demo.contoller;

import com.example.demo.StudentFactory;
import com.example.demo.TeacherFactory;
import com.example.demo.domain.Student;
import com.example.demo.respository.StudentRepository;
import com.example.demo.respository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherRepository teacherRepository;


//    @Autowired
//            @Qualifier("primaryStudentService")
//    StudentService studentService1;
//
//    @Autowired
//    @Qualifier("secondaryStudentService")
//    StudentService studentService2;

    @Autowired
    StudentFactory studentFactory;

    @Autowired
    TeacherFactory teacherFactory;

    // all students
    @GetMapping("/student")
    public List<Student> index() {
        System.out.println("Hello Welcome to the Student Controller");
//        return studentRepository.getStudentCountOfClass("primary");
        return studentRepository.findAll();
    }


    // details of student of ? id
    @GetMapping("/student/{id}")
    public Student show_student_details(@PathVariable int id) {
        return studentRepository.findById(id).get();
    }

    // all students of class type ?
    @GetMapping("/student/classtype/{classType}")
    public List<Student> show_student_of_class(@PathVariable String classType) {
        return studentFactory.getStudentService(classType).findByClassType(classType);
    }

//    // all students of class type primary // 10688
//    @GetMapping("/student/primary")
//    public List<Student> show_primary_student() {
//        return studentService1.findByClassType("primary");
//    }
//    // all students of class type secondary 10685
//    @GetMapping("/student/secondary")
//    public List<Student> show_secondary_student() {
//        return studentService2.findByClassType("secondary");
//    }

    // add student
    @PostMapping("/student/create")
    public Student create(@RequestBody Student s) {
//        List<Integer> idList = s.getTeachers().stream().map(p -> p.getTeacherId()).collect(Collectors.toList());
//        System.out.println(idList);
//        Teacher t = s.getTeachers().get(0);
//        if (teacherFactory.getTeacherService(t.getClassType()).validate(t.getTeacherId())){
//            return studentRepository.save(s);
//        }
//        teacherRepository.save(t);
        return studentRepository.save(s);
    }

//    // update student
//    @PutMapping("/student/update/{id}")
//    public Student update(@PathVariable int id, @RequestBody Map<String, String> body) {
//        Student s = studentRepository.findById(id).get();
////        Student s1 = studentRepository.findById(id).get();
//
//        s.setStudentName(body.get("studentName"));
//        s.setStudentPhone(body.get("studentPhone"));
//
////        s.setStudentName(null);
////        s.setStudentPhone(body.get("studentPhone"));
//
//        return studentRepository.save(s);
//    }

    // update student
    @PutMapping("/student/update/{id}")
    public Student update(@PathVariable int id, @RequestBody Student body) {
        Student s = studentRepository.findById(id).get();
//        Student s1 = studentRepository.findById(id).get();

        s.setStudentName(body.getStudentName());
        s.setStudentPhone(body.getStudentPhone());
        s.setClassType(body.getClassType());
        s.setTeachers(body.getTeachers());

//        s.setStudentName(null);
//        s.setStudentPhone(body.get("studentPhone"));

        return studentRepository.save(s);
    }

    // delete student
    @DeleteMapping("/student/delete/{id}")
    public Boolean delete(@PathVariable int id) {
        studentRepository.deleteById(id);
        return true;
    }


}
