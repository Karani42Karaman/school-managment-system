package com.karaman.schoolmanagmentsystem.serviceImpl;

import com.karaman.schoolmanagmentsystem.model.TeachersModel;
import com.karaman.schoolmanagmentsystem.repository.ITeachersRepository;
import com.karaman.schoolmanagmentsystem.service.ITeachersService;

import java.util.List;


public class TeacherServiceImpl implements ITeachersService {
    private ITeachersRepository teachersRepository;
    public TeacherServiceImpl (ITeachersRepository teachersRepository){
        this.teachersRepository = teachersRepository;
    }

    @Override
    public List<TeachersModel> getAllTeachers() {
       return teachersRepository.findAll();
    }


    @Override
    public TeachersModel saveTeacher(TeachersModel teachersModel) {
        return teachersRepository.save(teachersModel);
    }

    @Override
    public TeachersModel getTeacherById(Long id) {
        return teachersRepository.getById(id);
    }

    @Override
    public TeachersModel updateTeacher(TeachersModel teachersModel) {
        return teachersRepository.save(teachersModel);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teachersRepository.deleteById(id);
    }
}
