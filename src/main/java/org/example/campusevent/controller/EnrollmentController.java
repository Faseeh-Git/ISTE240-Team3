// Syed Faseeullah | 422000932

package org.example.campusevent.controller;

import org.example.campusevent.model.Enrollment;
import org.example.campusevent.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // 1. GET all enrollments
    @GetMapping
    public ResponseEntity<List<Enrollment>> getAll() {
        List<Enrollment> enrollments = enrollmentService.findAll();
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }

    // 2. GET one enrollment by ID
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getById(@PathVariable int id) {
        try {
            return enrollmentService.findById(id)
                    .map(enrollment -> new ResponseEntity<>(enrollment, HttpStatus.OK))
                    .orElse(new ResponseEntity<>((HttpHeaders) null, HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 3. GET search enrollments by student name
    @GetMapping("/search")
    public ResponseEntity<List<Enrollment>> search(@RequestParam String studentName) {
        try {
            List<Enrollment> enrollments = enrollmentService.findByStudentName(studentName);
            return new ResponseEntity<>(enrollments, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 4. POST create new enrollment
    @PostMapping
    public ResponseEntity<Enrollment> create(@RequestBody Enrollment enrollment) {
        try {
            Enrollment saved = enrollmentService.save(enrollment);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 5. PUT update existing enrollment
    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> update(@PathVariable int id,
                                             @RequestBody Enrollment enrollment) {
        try {
            Enrollment updated = enrollmentService.update(id, enrollment);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((HttpHeaders) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 6. DELETE enrollment by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            enrollmentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}