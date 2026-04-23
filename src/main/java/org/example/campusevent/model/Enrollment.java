package org.example.campusevent.model;

public class Enrollment {

    private int enrollmentId;
    private String studentName;
    private String eventName;
    private String date;

    // Default constructor (required for forms)
    public Enrollment() {}

    // Constructor for seed/sample data
    public Enrollment(int enrollmentId, String studentName, String eventName, String date) {
        this.enrollmentId = enrollmentId;
        this.studentName = studentName;
        this.eventName = eventName;
        this.date = date;
    }

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