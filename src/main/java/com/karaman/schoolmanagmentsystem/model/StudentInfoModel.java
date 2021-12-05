package com.karaman.schoolmanagmentsystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "studentInfoId")
@Table(name = "studentinfo")
public class StudentInfoModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "studentInfoId")
    private Long studentInfoId;
    @Column(name = "fatherName")
    private String fatherName;
    @Column(name = "motherName")
    private String motherName;
    @Column(name = "address")
    private String address;


}
