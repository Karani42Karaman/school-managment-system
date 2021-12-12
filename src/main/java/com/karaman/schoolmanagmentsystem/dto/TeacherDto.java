package com.karaman.schoolmanagmentsystem.dto;

import com.karaman.schoolmanagmentsystem.model.LessonsModel;
import com.karaman.schoolmanagmentsystem.model.TeachersModel;
import lombok.Data;

import java.util.List;

@Data
public class TeacherDto {
    public List<TeachersModel> teachersModels;
    public List<LessonsModel> lessonsModels;
}
