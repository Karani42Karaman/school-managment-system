package com.karaman.schoolmanagmentsystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

import java.util.Date;

@Entity
@Data
@Table(name = "teachers")
public class TeachersModel   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name="tcNumber")
    private Long tcNumber;

    @Column(name="name")
    private String name;

    @Column(name="surName")
    private String surName;

    @Column(name="phoneNumber")
    private Long phoneNumber;

    @Column(name="mail")
    private String mail;

    @Column(name = "gender")
    private boolean gender;

    @Temporal(TemporalType.DATE)
    private Date recordTime;
}
