package org.example.campusevent.controller;

import org.example.campusevent.model.Enrollment;
import org.example.campusevent.service.EnrollmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // Show all enrollments
    @GetMapping("/enrollment")
    public String getEnrollment(Model data) {

        data.addAttribute("enrollmentList", enrollmentService.findAll());

        return "enrollment";
    }

    // Show add enrollment form
    @GetMapping("/enrollment/add")
    public String showAddEnrollmentForm(Model data) {

        return "add-enrollment";
    }

    // Save enrollment
    @PostMapping("/enrollment/add")
    public String saveEnrollment(Enrollment enrollment) {

        this.enrollmentService.saveEnrollment(enrollment);

        return "success";
    }
}