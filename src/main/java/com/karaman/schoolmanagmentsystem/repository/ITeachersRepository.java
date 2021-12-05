package com.karaman.schoolmanagmentsystem.repository;

import com.karaman.schoolmanagmentsystem.model.TeachersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeachersRepository extends JpaRepository<TeachersModel,Long> {
}
