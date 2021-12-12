package com.karaman.schoolmanagmentsystem.dto;

import lombok.Data;


import java.util.Date;

@Data
public class TeacherCreateDto {
    private Long tcNumber;
    private String name;
    private String surName;
    private Long phoneNumber;
    private String mail;
    private boolean gender;
    private String password;
    private Date recordTime;
    private Long lessonId;
}
