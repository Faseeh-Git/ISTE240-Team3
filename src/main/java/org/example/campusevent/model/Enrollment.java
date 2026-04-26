// Syed Faseeullah | 422000932

package org.example.campusevent.model;

import jakarta.persistence.*;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enrollmentId;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "date", nullable = false)
    private String date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Enrollment() {}

    public Enrollment(String studentName, String eventName, String date) {
        this.studentName = studentName;
        this.eventName = eventName;
        this.date = date;
    }

    public Enrollment(String studentName, String eventName, String date, Student student) {
        this.studentName = studentName;
        this.eventName = eventName;
        this.date = date;
        this.student = student;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    @Override
    public String toString() {
        return "Enrollment [ID=" + enrollmentId +
                ", StudentName=" + studentName +
                ", EventName=" + eventName +
                ", Date=" + date + "]";
    }
}