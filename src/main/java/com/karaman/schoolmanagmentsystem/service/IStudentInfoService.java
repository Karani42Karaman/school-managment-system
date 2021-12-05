package com.karaman.schoolmanagmentsystem.service;

import com.karaman.schoolmanagmentsystem.model.StudentInfoModel;


import java.util.List;

public interface IStudentInfoService   {
    List<StudentInfoModel> getAllStudentInfo();
    StudentInfoModel saveStudentInfo(StudentInfoModel   infoModel);
    StudentInfoModel getStudentInfoById(Long id);
    StudentInfoModel updateStudentInfo(StudentInfoModel  infoModel  );
    void deleteStudentInfoById(Long id);
}
