package org.example.campusevent.model;

import org.springframework.stereotype.Component;

@Component
public class Enrollment {

    private int enrollmentId;
    private String studentName;
    private String eventName;
    private String date;

    public int getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(int enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Enrollment [ID=" + enrollmentId +
                ", Student=" + studentName +
                ", Event=" + eventName +
                ", Date=" + date + "]";
    }
}
