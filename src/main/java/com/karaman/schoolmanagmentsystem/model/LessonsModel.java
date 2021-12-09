package com.karaman.schoolmanagmentsystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Data
@Table(name = "lessons")
public class LessonsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    private Long lessonId;
    @Column(name = "lesson_name")
    private String lessonName;



    //bir öğrenci birden fazla ders alabilir
    @OneToMany(mappedBy = "lessonsModel", cascade = CascadeType.ALL)
    private Set<StudentsModel> student = new HashSet<>();
    public Set<StudentsModel> getStudentsModel() {
        return student;
    }
    public void setStudentsModel(Set<StudentsModel> student) {
        this.student = student;
        for (StudentsModel b : student) {
            b.setLessonsModel(this);
        }
    }




    //bir öğretmen birden fazla ders verebilir
    @OneToMany(mappedBy = "lessonsModel", cascade = CascadeType.ALL)
    private Set<TeachersModel> teacher = new HashSet<>();
    public Set<TeachersModel> getTeachersModel() {
        return teacher;
    }
    public void setTeachersModel(Set<TeachersModel> teacher) {
        this.teacher = teacher;
        for (TeachersModel b : teacher) {
            b.setLessonsModel(this);
        }
    }
}

