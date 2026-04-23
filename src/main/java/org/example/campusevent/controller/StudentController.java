package org.example.campusevent.controller;

import org.example.campusevent.model.Student;
import org.example.campusevent.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService){this.studentService = studentService;}

    @GetMapping("/student")
    public String getStudent(Model data){
        data.addAttribute("studentList", studentService.findAll());
        return "student";
    }
    @GetMapping("/student/add")
    public String showAddStudentForm(Model data){
        return "add-student";
    }
    @PostMapping("/student/add")
    public String saveStudent(Student student){
        this.studentService.saveStudent(student);
        return "success";
    }
}

