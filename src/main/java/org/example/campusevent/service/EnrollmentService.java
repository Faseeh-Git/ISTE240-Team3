// Syed Faseeullah | 422000932

package org.example.campusevent.service;

import jakarta.transaction.Transactional;
import org.example.campusevent.model.Enrollment;
import org.example.campusevent.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EnrollmentService {

    // Spring injects the repository automatically
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // GET all enrollments
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    // GET one enrollment by ID
    public Optional<Enrollment> findById(int id) {
        return enrollmentRepository.findById(id);
    }

    // SEARCH by student name
    public List<Enrollment> findByStudentName(String studentName) {
        return enrollmentRepository.findByStudentName(studentName);
    }

    // SAVE — validate student name before saving
    public Enrollment save(Enrollment enrollment) {
        if (enrollment.getStudentName() == null || enrollment.getStudentName().isEmpty())
            throw new IllegalArgumentException("Student name must be not empty or null");
        if (enrollmentRepository.existsByStudentName(enrollment.getStudentName()))
            throw new RuntimeException("Enrollment already exists: " + enrollment.getStudentName());
        return enrollmentRepository.save(enrollment);
    }

    // UPDATE — find existing enrollment then update fields
    public Enrollment update(int id, Enrollment updatedEnrollment) {
        Enrollment existing = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        existing.setStudentName(updatedEnrollment.getStudentName());
        existing.setEventName(updatedEnrollment.getEventName());
        existing.setDate(updatedEnrollment.getDate());
        return enrollmentRepository.save(existing);
    }

    // DELETE — find first then delete
    public void deleteById(int id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        enrollmentRepository.delete(enrollment);
    }
}