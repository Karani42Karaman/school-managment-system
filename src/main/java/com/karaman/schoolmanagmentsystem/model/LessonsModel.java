package com.karaman.schoolmanagmentsystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Data
@Table(name = "lessons")
public class LessonsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    private Long lessonId;
    @Column(name = "grade")
    private Long grade;
    @Column(name = "absence")
    private Long absence;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studentModel_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private StudentsModel studentsModel;

}

