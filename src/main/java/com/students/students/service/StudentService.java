package com.students.students.service;

import com.students.students.dto.StudentDTO;
import com.students.students.model.Student;
import com.students.students.repository.AddressRepository;
import com.students.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final AddressRepository addressRepository;

    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
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

    public void deleteStudent(StudentDTO studentDTO, Integer studId) {
        var stud = studentRepository.getById(studId);
       var adds = addressRepository.findAll();
       for(var a: adds){
           if(Objects.equals(a.getStudent().getSid(), studId)){
               addressRepository.delete(a);
               break;
           }
       }
        studentRepository.delete(stud);
    }
}
