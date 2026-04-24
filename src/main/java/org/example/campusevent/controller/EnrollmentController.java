// Syed Faseeullah | 422000932

package org.example.campusevent.controller;

import org.example.campusevent.model.Enrollment;
import org.example.campusevent.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// REST Controller for Enrollment — handles all HTTP requests for /api/enrollments
// No @Controller needed, @RestController already handles JSON responses

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {

    // Spring automatically injects the EnrollmentService
    @Autowired
    private EnrollmentService enrollmentService;

    // 1. GET all enrollments
    @GetMapping
    public List<Enrollment> getAll() {
        return enrollmentService.findAll();
    }

    // 2. GET one enrollment by ID — returns 404 if not found
    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getById(@PathVariable int id) {
        return enrollmentService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. GET search by student name
    @GetMapping("/search")
    public List<Enrollment> search(@RequestParam String studentName) {
        return enrollmentService.findByStudentName(studentName);
    }

    // 4. POST create new enrollment
    @PostMapping
    public Enrollment create(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }

    // 5. PUT update existing enrollment — finds by ID then updates fields
    @PutMapping("/{id}")
    public Enrollment update(@PathVariable int id, @RequestBody Enrollment enrollment) {
        return enrollmentService.update(id, enrollment);
    }

    // 6. DELETE enrollment by ID — removes record from database
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        enrollmentService.deleteById(id);
    }
}