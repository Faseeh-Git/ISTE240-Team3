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

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // GET all enrollments from database
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    // GET one enrollment by ID
    public Optional<Enrollment> findById(int id) {
        return enrollmentRepository.findById(id);
    }

    // SEARCH enrollments by student name
    public List<Enrollment> findByStudentName(String studentName) {
        return enrollmentRepository.findByStudentName(studentName);
    }

    // SAVE new enrollment to database
    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    // UPDATE existing enrollment —
    public Enrollment update(int id, Enrollment updatedEnrollment) {
        Enrollment existing = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enrollment not found"));
        existing.setStudentName(updatedEnrollment.getStudentName());
        existing.setEventName(updatedEnrollment.getEventName());
        existing.setDate(updatedEnrollment.getDate());
        return enrollmentRepository.save(existing);
    }

    // DELETE enrollment
    public void deleteById(int id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Delete failed"));
        enrollmentRepository.delete(enrollment);
    }
}