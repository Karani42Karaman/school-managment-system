package com.karaman.schoolmanagmentsystem.serviceImpl;

import com.karaman.schoolmanagmentsystem.model.StudentInfoModel;
import com.karaman.schoolmanagmentsystem.repository.IStudentInfoRepository;
import com.karaman.schoolmanagmentsystem.service.IStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoServiceImpl implements IStudentInfoService {
    @Autowired
    private IStudentInfoRepository studentInfoRepository;

    public StudentInfoServiceImpl(IStudentInfoRepository studentInfoRepository) {
        this.studentInfoRepository = studentInfoRepository;
    }

    @Override
    public List<StudentInfoModel> getAllStudentInfo() {
        return studentInfoRepository.findAll();
    }

    @Override
    public StudentInfoModel saveStudentInfo(StudentInfoModel infoModel) {
        return studentInfoRepository.save(infoModel);
    }

    @Override
    public StudentInfoModel getStudentInfoById(Long id) {
        return studentInfoRepository.getById(id);
    }

    @Override
    public StudentInfoModel updateStudentInfo(StudentInfoModel infoModel) {
        return studentInfoRepository.save(infoModel);
    }

    @Override
    public void deleteStudentInfoById(Long id) {
        studentInfoRepository.deleteById(id);
    }
}
