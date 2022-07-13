package com.students.students.service;

import com.students.students.dto.StudentDTO;
import com.students.students.model.Student;
import com.students.students.repository.AddressRepository;
import com.students.students.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
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
            return new Student(studentDTO.getSfirstname(), studentDTO.getSlastname(),studentDTO.getEmail(),studentDTO.getPhone(), studentDTO.getGrade());
        }
        return null;
    }
    public StudentDTO convertModelToDTO(Student student){
        if(student!=null){
            return new StudentDTO(student.getSfirstname(), student.getSlastname(),student.getEmail(),student.getPhone(),student.getSid(), student.getGrade());
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
        if(!student.getEmail().isEmpty())
            stud.setEmail(student.getEmail());
        if(!student.getPhone().isEmpty())
            stud.setPhone(student.getPhone());
        if(!student.getSfirstname().isEmpty())
            stud.setSfirstname(student.getSfirstname());
        if(!student.getSlastname().isEmpty())
            stud.setSlastname(student.getSlastname());
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

    public Student getById(Integer id){
        return studentRepository.getById(id);
    }

    public List<StudentDTO> getStudentsByName(String firstname){
        List<Student> students = studentRepository.getStudentsBySfirstnameContains(firstname);
        return students.stream().map(this::convertModelToDTO).toList();
    }
    public List<StudentDTO> getStudentsGradesSorted(){
        List<Student> students = studentRepository.findByOrderByGradeAsc();
        return students.stream().map(this::convertModelToDTO).toList();
    }

    public List<StudentDTO> getStudentsGradesSortedCustom() {
        var students = studentRepository.findAll();
        students.sort(Comparator.comparing(Student::getGrade));
        return students.stream().map(this::convertModelToDTO).toList();
    }
}

