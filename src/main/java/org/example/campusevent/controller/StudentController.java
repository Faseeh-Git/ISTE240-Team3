// Haya Khan 746008798
package org.example.campusevent.controller;

import org.example.campusevent.model.Student;
import org.example.campusevent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")

public class StudentController {
    @Autowired
    private StudentService studentService;
//    public StudentController(StudentService studentService){this.studentService = studentService;}

    @GetMapping
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        return studentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/search")
    public List<Student> searchByMajor(@RequestParam String major) {
        return studentService.findByMajor(major);
    }
    @PostMapping
    public Student create(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // 6. DELETE (Requirement 3)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}

