// Haya Khan 746008798
package org.example.campusevent.service;

import jakarta.transaction.Transactional;
import org.example.campusevent.model.Student;
import org.example.campusevent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> findById (Long id){
        return studentRepository.findById(id);
    }

    public List<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    public List<Student> findByMajor(String major) {
        return studentRepository.findByMajor(major);
    }

    public Student saveStudent(Student student) {
        if (student.getEmail() == null || student.getEmail().isEmpty())
            throw new IllegalArgumentException("Email must be not empty or null");

        if (studentRepository.existsByEmail(student.getEmail()))
            throw new RuntimeException("Email already exists: " + student.getEmail());

        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setMajor(updatedStudent.getMajor());
        return studentRepository.save(existing);
    }


    public void deleteById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        studentRepository.delete(student);
    }
    }
