package org.example.campusevent.service;

import org.example.campusevent.model.Enrollment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentService {

    List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentService(){

        var enrollment1 = new Enrollment(1,"Faseeh","Hackathon","2026-04-01");
        var enrollment2 = new Enrollment(2,"Syed","Coding Contest","2026-04-10");

        this.enrollments.add(enrollment1);
        this.enrollments.add(enrollment2);

    }

    public List<Enrollment> findAll(){
        return this.enrollments;
    }

    public void saveEnrollment(Enrollment enrollment){
        this.enrollments.add(enrollment);
    }
}