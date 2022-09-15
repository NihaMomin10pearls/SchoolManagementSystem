package com.example.demo.respository;

import com.example.demo.domain.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByClassType(String classType); // bad practice

    // find one student if use findby not use list -> good practice

    List<Student> findAllByClassType(String classType); // good practice

    List<Student> findFirst2ByClassType(String classType);

    List<Student> findAllByStudentNameOrderByStudentIdAsc(String name);

    List<Student> findAllByOrderByStudentNameDesc();

    // find column not possible
//    List<Student> getStudentName();
    // and or ki implementation
    Student findAllByStudentIdAndStudentNameOrderByStudentIdAsc(int id, String name);
//    Student findByClassType(String classType);

    // query
//    @Transactional
//    @Query(value = "SELECT * FROM Student", nativeQuery = true)
//    List<Student> getStudents();

    @Transactional
    @Query(value = "select  s.studentName FROM Student s", nativeQuery = false)
    List<String> getStudentNameColumn();

    @Transactional
    @Query(value = "SELECT  s.studentName FROM Student s WHERE s.classType = :name", nativeQuery = false)
    List<String> getStudentOfClass(String name);

    @Transactional
    @Query(value = "SELECT  s.classType FROM Student s WHERE s.studentId = :id AND s.studentName = :name", nativeQuery = false)
    List<String> getStudentClassFromIdAndName(int id, String name);

    // aggregate functions
//    @Transactional
//    @Query(value = "SELECT COUNT(*) FROM Student s WHERE s.classType = :classType", nativeQuery = false)
//    Integer getStudentCountOfClass(String classType);

    @Transactional
    @Query(value = "SELECT COUNT(*) FROM Student s WHERE s.classType = :name", nativeQuery = false)
    int getStudentCountOfClass(String name);

    // joins
//    @Transactional
//    @Query(value = "FROM Student s JOIN Teacher t WHERE t.teacherId = :id", nativeQuery = false)
//    List<Object> getdata(int id);

    // fetch data of student with teacher


    // in, having, between keywords

}
