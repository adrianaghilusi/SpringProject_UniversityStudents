package com.students.students.service;

import com.students.students.dto.StudentDTO;
import com.students.students.model.Student;
import com.students.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student convertDTOtoModel(StudentDTO studentDTO){
        if(studentDTO!=null){
            return new Student(studentDTO.sfirstname, studentDTO.slastname,studentDTO.email,studentDTO.phone);
        }
        return null;
    }
    public void addStudent(StudentDTO studentToAdd) throws Exception {
        if(studentToAdd == null){
            throw new Exception("Student is null");
        }else{
            Student s = convertDTOtoModel(studentToAdd);
            studentRepository.saveAndFlush(s);
        }
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
