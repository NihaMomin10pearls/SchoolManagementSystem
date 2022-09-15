package com.example.demo.respository;

import com.example.demo.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    //    List<Teacher> findByTeacherNameContainingTeacherPhone(String name, String phone)
    List<Teacher> findByClassType(String classType);
}
