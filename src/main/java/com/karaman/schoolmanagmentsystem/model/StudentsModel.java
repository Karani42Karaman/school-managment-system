package com.karaman.schoolmanagmentsystem.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "students")
public class StudentsModel {

    public StudentsModel(String password, Long tcNumber, String name, String surName, Long schoolNumber, Long schoolClass, Long phoneNumber, String mail, boolean gender, Date recordTime) {
        this.tcNumber = tcNumber;
        this.name = name;
        this.surName = surName;
        this.mail = mail;
        this.password = password;
        this.schoolNumber = schoolNumber;
        this.schoolClass = schoolClass;
        this.phoneNumber = phoneNumber;
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

    @Column(name = "password")
    private String password;

    @Temporal(TemporalType.DATE)
    private Date recordTime;

    // bir den falz öğrenciye bir müdür bakar
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_model_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ManagerModel managerModel;

    //bir öğrencinin bir infosu olur
    @OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "studentsModel")
    private StudentInfoModel studentInfoModel;







}
