package com.karaman.schoolmanagmentsystem.service;

import com.karaman.schoolmanagmentsystem.model.TeachersModel;

import java.util.List;

public interface ITeachersService  {
    List<TeachersModel> getAllTeachers();
    TeachersModel saveTeacher(TeachersModel   teachersModel);
    TeachersModel getTeacherById(Long id);
    TeachersModel updateTeacher(TeachersModel teachersModel);
    void deleteTeacherById(Long id);
}
