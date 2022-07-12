package com.students.students.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.students.students.dto.StudentDTO;
import com.students.students.model.Student;
import com.students.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService stud) {
        this.studentService = stud;
    }

    @RequestMapping(value = "/intro")
    public String index() {
        return "intro";
    }
    @RequestMapping("/")
    public String homePage(Model model) {
        return "home";
    }
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        model.addAttribute("allStudents",studentService.getAllStudents() );
        return "../templates/allStudents";
    }
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String createStudent(Model model, @RequestBody Student student){
        Student stud  = studentService.createStudent(student);
        return "redirect:/students";
    }
    @RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.PUT)
    public String updateStudent(Model model, @RequestBody StudentDTO student, @PathVariable (value = "id") Integer studId){
        Student stud  = studentService.updateStudent(student,studId);
        return "redirect:/students";
    }

}
