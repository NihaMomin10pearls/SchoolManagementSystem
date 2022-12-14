package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Entity
public class
Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;
    private String teacherName;
    private String teacherPhone;
    private String classType;

//    @OneToOne(mappedBy = "teacher")
//    private Student student;

//    @OneToMany(mappedBy = "teacher")
//    @JsonManagedReference
//    private List<Student> students;
//
//    public List<Student> getStudents() {
//        return this.students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    @ManyToMany(mappedBy = "teachers")
    @JsonIgnore
    @Autowired
    private List<Student> students;
    // field based DI

    public Teacher() {
    }

    public Teacher(int teacher_id, String teacher_name, String teacher_phone, String classType) {
        this.teacherId = teacher_id;
        this.teacherName = teacher_name;
        this.teacherPhone = teacher_phone;
        this.classType = classType;
    }

    public Teacher(String teacher_name, String teacher_phone, String classType) {
        this.teacherName = teacher_name;
        this.teacherPhone = teacher_phone;
        this.classType = classType;
    }

    // Constructor based DI
    public Teacher(int teacher_id, String teacher_name, String teacher_phone, String classType, List<Student> studentList) {
        this.teacherId = teacher_id;
        this.teacherName = teacher_name;
        this.teacherPhone = teacher_phone;
        this.classType = classType;
        this.students = studentList;
    }

    public List<Student> getStudents() {
        return students;
    }

    // setter based DI
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhone() {
        return this.teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getClassType() {
        return this.classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    @Override
    public String toString() {
        return "Teacher ID = " + this.teacherId + " Teacher Name = " + this.teacherName +
                " Teacher phone = " + this.teacherPhone + " Tecaher class type = " + this.classType;
    }
}
