package org.example.campusevent.service;

import org.example.campusevent.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<Student> students = new ArrayList<Student>();

    public StudentService() {
        var student1 = new Student(123,"Emma","Emma@gmail.com","CIT");
        var student2 = new Student(456,"Dan","Dan@gmail.com","CSEC");
        this.students.add(student1);
        this.students.add(student2);
    }

    public List<Student> findAll(){return this.students;}

    public void saveStudent(Student student) {
        this.students.add(student);
    }
}

