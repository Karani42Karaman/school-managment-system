package com.karaman.schoolmanagmentsystem.repository;

import com.karaman.schoolmanagmentsystem.model.LessonsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILessonsRepository extends JpaRepository<LessonsModel,Long> {
}
