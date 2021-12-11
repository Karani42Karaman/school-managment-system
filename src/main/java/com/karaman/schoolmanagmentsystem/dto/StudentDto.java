package com.karaman.schoolmanagmentsystem.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    //Student
    private Long tcNumber;
    private String name;
    private String surname;
    private String email;
    private Long phone;
    private String password;
    private String schoolNumber;
    private String classNumber;
    private boolean gender;
    //Lesson
    private Long lessonId;
    private List<String> lessonName;
    //teacher
    private Long teacherId;
    private List<String> teacherName;
}
