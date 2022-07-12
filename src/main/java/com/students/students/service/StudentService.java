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
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(StudentDTO student, Integer studId) {
        var stud = studentRepository.getById(studId);
        var conv = convertDTOtoModel(student);
        if(!student.email.isEmpty())
            stud.setEmail(student.email);
        if(!student.phone.isEmpty())
            stud.setPhone(student.phone);
        if(!student.sfirstname.isEmpty())
            stud.setSfirstname(student.sfirstname);
        if(!student.slastname.isEmpty())
            stud.setSlastname(student.slastname);
        return studentRepository.save(stud);

    }
}
