package com.karaman.schoolmanagmentsystem.serviceImpl;

import com.karaman.schoolmanagmentsystem.model.StudentsModel;

import com.karaman.schoolmanagmentsystem.repository.IStudentRepository;
import com.karaman.schoolmanagmentsystem.service.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentsService {
    @Autowired
    private IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentsModel save(StudentsModel registrationDto) {
        return null;
    }

    @Override
    public List<StudentsModel> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentsModel saveStudent(StudentsModel studentsModel) {
        return studentRepository.save(studentsModel);
    }

    @Override
    public StudentsModel getStudentById(Long id) {
        return studentRepository.getById(id);
    }

    @Override
    public StudentsModel updateStudent(StudentsModel studentsModel) {
        return studentRepository.save(studentsModel);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
