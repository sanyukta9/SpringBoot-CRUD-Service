package com.example.Task1.Student_Data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "StudentData")
public class Student {

    // Getter and Setter methods
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studId;

    @Column(name = "firstname")
    private String studFname;

    @Column(name = "Lastname")
    private String studLname;

    @Column(name = "Coursename")
    private String courseName;

    // Default constructor
    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "studId=" + studId +
                ", studFname='" + studFname + '\'' +
                ", studLname='" + studLname + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
