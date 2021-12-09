package com.karaman.schoolmanagmentsystem.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "manager")
public class ManagerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "manager_id")
    private Long managerId;
    @Column(name = "manager_name")
    private String managerName;
    @Column(name = "manager_email")
    private String managerEmail;
    @Column(name = "manager_password")
    private String managerPassword;
    @Column(name = "tcNumber")
    private Long tcNumber;
    @Column(name = "manager_phone")
    private String managerPhone;
    @Column(name = "manager_address")
    private String managerAddress;
    @Column(name = "manager_gender")
    private String managerGender;
    @Temporal(TemporalType.DATE)
    private Date recordTime;


    //bir müdür birden fazla öğrenciye bakar
    @OneToMany(mappedBy = "managerModel", cascade = CascadeType.ALL)
    private Set<StudentsModel> studentsModels = new HashSet<>();
    public Set<StudentsModel> getStudentsModels() {
        return studentsModels;
    }
    public void setStudentsModel(Set<StudentsModel> studentsModels) {
        this.studentsModels = studentsModels;
        for (StudentsModel b : studentsModels) {
            b.setManagerModel(this);
        }
    }

    //bir müdür birden fazla öğretmene  bakar
    @OneToMany(mappedBy = "managerModel", cascade = CascadeType.ALL)
    private Set<TeachersModel>  teachersModels = new HashSet<>();
    public Set<TeachersModel> getTeachersModel() {
        return teachersModels;
    }
    public void setTeachersModel(Set<TeachersModel> teachersModels) {
        this.teachersModels = teachersModels;
        for (TeachersModel b : teachersModels) {
            b.setManagerModel(this);
        }
    }








}
