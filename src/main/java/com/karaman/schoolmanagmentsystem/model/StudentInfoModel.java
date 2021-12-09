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

    @Column(name = "lessonName")// DERS ADI
    private String lessonName;

    @Column(name = "right_of_absence")//DEVAMSIZLIK HAKKI
    private String rightOfAbsence;

    @Column(name = "lecture_note_one")
    private int lectureNoteOne;

    @Column(name = "lecture_note_Two")
    private int lectureNoteTwo;

    @Column(name = "lecture_note_Three")
    private int lectureNoteThree;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "student_id", nullable = false)
    private StudentsModel studentsModel;


}
