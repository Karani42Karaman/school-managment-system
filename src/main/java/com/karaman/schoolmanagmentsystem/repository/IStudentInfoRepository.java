package com.karaman.schoolmanagmentsystem.repository;

import com.karaman.schoolmanagmentsystem.model.StudentInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentInfoRepository extends JpaRepository<StudentInfoModel,Long> {
}
