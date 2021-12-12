package com.karaman.schoolmanagmentsystem.dto;

import lombok.Data;

@Data
public class InfoCreateDto {
    public InfoCreateDto(int teacherId, int lectureNoteOne, int lectureNoteTwo, int lectureNoteThree, String rightOfAbsence) {
        this.teacherId = teacherId;
        this.lectureNoteOne = lectureNoteOne;
        this.lectureNoteTwo = lectureNoteTwo;
        this.lectureNoteThree = lectureNoteThree;
        this.rightOfAbsence = rightOfAbsence;
    }

    public int teacherId;
    public int lectureNoteOne;
    public int lectureNoteTwo;
    public int lectureNoteThree;
    public String rightOfAbsence;
}
