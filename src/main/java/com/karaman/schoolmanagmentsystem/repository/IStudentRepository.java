package com.karaman.schoolmanagmentsystem.repository;

import com.karaman.schoolmanagmentsystem.model.StudentsModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<StudentsModel,Long> {

}
