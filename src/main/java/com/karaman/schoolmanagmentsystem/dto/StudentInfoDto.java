package com.karaman.schoolmanagmentsystem.dto;

import com.karaman.schoolmanagmentsystem.model.StudentInfoModel;
import com.karaman.schoolmanagmentsystem.model.StudentsModel;
import com.karaman.schoolmanagmentsystem.model.TeachersModel;
import lombok.Data;

import java.util.List;

@Data
public class StudentInfoDto {
    //Student
    public List<StudentsModel> studentList;
    public List<TeachersModel> teacherList;
    public List<StudentInfoModel> studentInfoList;
}
