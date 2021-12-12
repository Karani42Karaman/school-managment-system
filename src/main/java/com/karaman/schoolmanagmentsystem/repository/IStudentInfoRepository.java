package com.karaman.schoolmanagmentsystem.repository;

import com.karaman.schoolmanagmentsystem.model.StudentInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentInfoRepository extends JpaRepository<StudentInfoModel, Long> {

    @Query(value = "SELECT * FROM studentinfo WHERE student_id = ?1", nativeQuery = true)
    public List<StudentInfoModel> findByStudentId(Long studentId);

}
