package com.karaman.schoolmanagmentsystem.model;


import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "students")
public class StudentsModel{

    public StudentsModel(Long tcNumber, String name, String surName, Long schoolNumber, Long schoolClass, Long phoneNumber, String mail, boolean gender, Date recordTime) {
        this.tcNumber = tcNumber;
        this.name = name;
        this.surName = surName;
        this.schoolNumber = schoolNumber;
        this.schoolClass = schoolClass;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.gender = gender;
        this.recordTime = recordTime;
    }

    public StudentsModel() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "tcNumber")
    private Long tcNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "surName")
    private String surName;

    @Column(name = "schoolNumber")
    private Long schoolNumber;

    @Column(name = "schoolClass")
    private Long schoolClass;

    @Column(name = "phoneNumber")
    private Long phoneNumber;

    @Column(name = "mail")
    private String mail;

    @Column(name = "gender")
    private boolean gender;

    @Temporal(TemporalType.DATE)
    private Date recordTime;


    @OneToMany(mappedBy = "studentsModel", cascade = CascadeType.ALL)
    private Set<LessonsModel> lessons = new HashSet<>();

    public Set<LessonsModel> getLessonModel() {
        return lessons;
    }
    public void setBooks(Set<LessonsModel> lessons) {
        this.lessons = lessons;
        for(LessonsModel b : lessons) {
            b.setStudentsModel(this);
        }
    }
}
