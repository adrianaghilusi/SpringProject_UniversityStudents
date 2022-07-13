package com.students.students.repository;

import com.students.students.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> getStudentsBySfirstnameContains(String name);
    List<Student> findByOrderByGradeAsc();
}
