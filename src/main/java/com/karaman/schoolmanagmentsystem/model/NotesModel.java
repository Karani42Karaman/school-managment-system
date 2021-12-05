package com.karaman.schoolmanagmentsystem.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "notes")
public class NotesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincreament
    @Column(name = "notes_id")
    private Long studentId;

    @Column(name = "name")
    private String name;
}
