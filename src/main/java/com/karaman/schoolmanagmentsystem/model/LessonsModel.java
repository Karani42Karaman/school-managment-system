package com.karaman.schoolmanagmentsystem.model;

import lombok.Data;

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

