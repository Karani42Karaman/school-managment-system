package com.karaman.schoolmanagmentsystem.service;

import com.karaman.schoolmanagmentsystem.model.StudentInfoModel;


import java.util.List;

public interface IStudentInfoService   {
    List<StudentInfoModel> getAllStudentInfo();
    StudentInfoModel saveStudentInfo(StudentInfoModel   infoModel);
 
    StudentInfoModel updateStudentInfo(StudentInfoModel  infoModel  );
    void deleteStudentInfoById(Long id);

    List<StudentInfoModel> getStudentInfoByStudentId(Long student_id);
}
