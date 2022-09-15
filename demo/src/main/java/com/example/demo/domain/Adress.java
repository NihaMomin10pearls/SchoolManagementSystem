package com.example.demo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.io.Serializable;
import java.util.List;

@Entity
public class Adress implements Serializable {

    @Id
    private int postalCode;

    @OneToMany(mappedBy = "adress", cascade = CascadeType.PERSIST)
    private List<Student> students;

    public Adress() {
    }

    public Adress(int postalCode, List<Student> students) {
        this.postalCode = postalCode;
        this.students = students;
    }

    public int getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
