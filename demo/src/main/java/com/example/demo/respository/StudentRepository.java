package com.example.demo.respository;

import com.example.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    List<Student> findByStudentNameContainingStudentPhone(String name, String phone);

}
