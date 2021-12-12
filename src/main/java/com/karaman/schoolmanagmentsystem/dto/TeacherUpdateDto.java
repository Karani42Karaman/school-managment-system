package com.karaman.schoolmanagmentsystem.dto;

import com.karaman.schoolmanagmentsystem.model.LessonsModel;
import com.karaman.schoolmanagmentsystem.model.TeachersModel;


import java.util.List;

public class TeacherUpdateDto {
    public TeachersModel teachersModel;
    public  List<LessonsModel> lessonsModelList;
}
