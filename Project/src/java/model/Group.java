/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author win
 */
public class Group {
    int id;
    String name;
    private Courses course;
    private Instructor lecturer;
    private ArrayList<Student> students;
    private ArrayList<SessionGroup> sessions;
    String sem;
    int year;

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public Instructor getLecturer() {
        return lecturer;
    }

    public void setLecturer(Instructor lecturer) {
        this.lecturer = lecturer;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<SessionGroup> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<SessionGroup> sessions) {
        this.sessions = sessions;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
}
