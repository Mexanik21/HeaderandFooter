package com.example.students.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String fullName;
    private String course;
    private int profile;
    private boolean available = false;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Student(String fullName, String course, int profile, boolean available) {
        this.fullName = fullName;
        this.course = course;
        this.profile = profile;
        this.available = available;
    }
}
