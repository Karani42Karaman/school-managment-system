package com.karaman.schoolmanagmentsystem.service;

import com.karaman.schoolmanagmentsystem.model.StudentsModel;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IStudentsService extends UserDetailsService {
    StudentsModel save(StudentsModel registrationDto);
    List<StudentsModel> getAllStudents();
    StudentsModel saveStudent(StudentsModel   studentsModel);
    StudentsModel getStudentById(Long id);
    StudentsModel updateStudent(StudentsModel studentsModel);
    void deleteStudentById(Long id);
}
