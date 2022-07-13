package com.students.students.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.students.students.dto.StudentDTO;
import com.students.students.model.Student;
import com.students.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
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
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createStudent( Student student){
        Student stud  = studentService.createStudent(student);
        return "redirect:/students";

    }
    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(){
        return "../templates/addStudent";
    }
    @RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.GET)
    public ModelAndView getUpdateStudent(@PathVariable (value = "id") Integer studId){
        Student stud  = studentService.getById(studId);
        ModelAndView modelAndView = new ModelAndView("../templates/updateStudent").addObject("student", stud);
        return modelAndView;
    }
    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateStudent(Model model,StudentDTO student){
        Student stud  = studentService.updateStudent(student, student.getSid());
        return "redirect:/students";
    }

    @RequestMapping(value ="/deleteStudent/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(Model model, @RequestBody StudentDTO studentDTO, @PathVariable (value = "id") Integer studId)
    {

        studentService.deleteStudent(studentDTO,studId);
        return "redirect:/students";
    }
    @RequestMapping(value ="/students/names/{firstname}", method = RequestMethod.GET)
    public String getStudentsByName(Model model, @PathVariable (value="firstname") String firstname)
    {
        model.addAttribute("allStudents",studentService.getStudentsByName(firstname));
        return "../templates/allStudents";
    }
}
