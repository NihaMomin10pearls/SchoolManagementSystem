package com.example.demo.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String studentName;
    private String studentPhone;

//    @OneToOne
//    @JoinColumn(name = "fk_teacher_id")
//    private Teacher teacher;

//    @ManyToOne
//    @JoinColumn(name="fk_teacher_id", nullable = true)
//    @JsonBackReference
//    private Teacher teacher;

//    public Teacher getTeacher() {
//        return this.teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }

    @ManyToMany
    @JoinTable(name = "teacher_has_student",
            joinColumns = @JoinColumn(name = "student_student_id", referencedColumnName = "studentId"),
            inverseJoinColumns = @JoinColumn(name = "teacher_teacher_id",
                    referencedColumnName = "teacherId"))
    private List<Teacher> teachers;

    public Student() {
    }

    public Student(String student_name, String student_phone) {
        this.studentName = student_name;
        this.studentPhone = student_phone;
    }

    public Student(int studentId, String student_name, String student_phone) {
        this.studentId = studentId;
        this.studentName = student_name;
        this.studentPhone = student_phone;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentPhone() {
        return this.studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    @Override
    public String toString() {
        return "Student ID = " + this.studentId + " Student Name = " + this.studentName +
                " Student phone = " + this.studentPhone;
//                + " " + this.teacher.toString();
    }

}

