package org.example.campusevent.model;

import org.springframework.stereotype.Component;


public class Student {
    private int studentID;
    private String name;
    private String email;
    private String major;

    public Student() { }

    public Student(int studentID, String name, String email, String major){
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.major = major;
    }

    public int getStudentID(){
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}


