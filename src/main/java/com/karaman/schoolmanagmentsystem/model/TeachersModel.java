package com.karaman.schoolmanagmentsystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "teachers")
public class TeachersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "tcNumber")
    private Long tcNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "surName")
    private String surName;

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


    // bir den falz öğretmene bir müdür bakar
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_model_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ManagerModel managerModel;


    //bir dersi birden fazla öğretmen  verebilir
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "lesson_model_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LessonsModel lessonsModel;


}
